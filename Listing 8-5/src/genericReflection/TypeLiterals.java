package genericReflection;

import java.lang.reflect.*;
import java.util.*;
import java.util.function.Function;

//Literał typowy opisuje typ, który może być generyczny, na przykład
class TypeLiteral<T> {
    private Type type;

    //ten konstruktor musi być wywoływany z anonimowej podklasy jako new TypeLiteral<...>(){}.
    public TypeLiteral() {
        Type parentType = getClass().getGenericSuperclass();
        if (parentType instanceof ParameterizedType) {
            type = ((ParameterizedType) parentType).getActualTypeArguments()[0];
        } else
            throw new UnsupportedOperationException(
                    "Construct as new TypeLiteral&lt:...&gt:(){}");
    }

    private TypeLiteral(Type type) {
        this.type = type;
    }

    //zwraca literał typowy opisujący dany typ
    public static TypeLiteral<?> of(Type type) {
        return new TypeLiteral<Object>(type);
    }

    public String toSpring() {
        if (type instanceof Class) return ((Class<?>) type).getName();
        else return type.toString();
    }

    public boolean equals(Object otherObject) {
        return otherObject instanceof TypeLiteral && type.equals(((TypeLiteral<?>) otherObject).type);
    }

    public int hashCode() {
        return type.hashCode();
    }
}

//formatuje obiekty przy użyciu reguł wiążących typy z funkcjami formatującymi
class Formatter {
    private Map<TypeLiteral<?>, Function<?, String>> rules = new HashMap<>();

    //dodaje regułę formatowania do tego formatera
    public <T> void forType(TypeLiteral<T> type, Function<T, String> formatterForType) {
        rules.put(type, formatterForType);
    }

    //formatuje wszystkie pola obiektu przy użyciu reguł tego formatera
    public String formatFields(Object obj)
            throws IllegalArgumentException, IllegalAccessException {
        var result = new StringBuilder();
        for (Field f : obj.getClass().getDeclaredFields()) {
            result.append(f.getName());
            result.append("=");
            f.setAccessible(true);
            Function<?, String> formatterForType = rules.get(TypeLiteral.of(f.getGenericType()));
            if (formatterForType != null) {
                //formatterForType ma typ parametru ?. Nic nie można przekazać do metody apply
                //Rzutowanie zamienia typ parametru na object, aby można było wykonać wywołanie
                @SuppressWarnings("unchecked")
                Function<Object, String> objectFormatter = (Function<Object, String>) formatterForType;
                result.append(objectFormatter.apply(f.get(obj)));
            } else result.append(f.get(obj).toString());
            result.append("\n");
        }
        return result.toString();
    }
}

public class TypeLiterals {
    public static class Sample {
        ArrayList<Integer> nums;
        ArrayList<Character> chars;
        ArrayList<String> strings;

        public Sample() {
            nums = new ArrayList<>();
            nums.add(42);
            nums.add(1729);
            chars = new ArrayList<>();
            chars.add('H');
            chars.add('i');
            strings = new ArrayList<>();
            strings.add("Hello");
            strings.add("World");
        }
    }

    private static <T> String join(String separator, ArrayList<T> elements) {
        var result = new StringBuilder();
        for (T e : elements) {
            if (result.length() > 0) result.append(separator);
            result.append(e.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        var formatter = new Formatter();
        formatter.forType(new TypeLiteral<ArrayList<Integer>>() {
        }, lst -> join(" ", lst));
        formatter.forType(new TypeLiteral<ArrayList<Character>>() {
        }, lst -> "\"" + join("", lst) + "\"");
        System.out.println(formatter.formatFields(new Sample()));
    }
}
