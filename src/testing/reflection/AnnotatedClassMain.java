package testing.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotatedClassMain {

    private static AnnotatedClass a;

    public static void main(String[] args) {
        a = new AnnotatedClass("Dupa");
        //getClassName();
        //getTypeAnnotation();

        Class b = a.getClass();
        try {
            Method x = b.getMethod("setNapis", String.class);
            x.invoke(a, "O w dupe dziala");

        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        print("Dupa");
        print(a.getNapis());
    }

    public static void getTypeAnnotation() {
        Class aClass = AnnotatedClass.class;
        Annotation[] annotations = aClass.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotationType) {
                print("A " + annotation.getClass().getName());
                print(annotation.toString());

                Class d = annotation.annotationType();
                print("X " + d.getSimpleName());
                print("X " + d.getName());
                print("X " + d.getCanonicalName());

                Class b = annotation.getClass();
                print(b.getSimpleName());
                print(b.getName());
                print(b.getCanonicalName());

                Class c = MyAnnotationType.class;
                print(c.getSimpleName());
                print(c.getName());
                print(c.getCanonicalName());


                MyAnnotationType myAnnotation = (MyAnnotationType) annotation;
                print("B " + myAnnotation.getClass().getName());
            }
        }
    }

    public static void getClassName() {
        Class aClass = AnnotatedClass.class;
        print("getName() " + aClass.getName());
        print("getSimpleName() " + aClass.getSimpleName());
        print("getCanonicalName " + aClass.getCanonicalName());
    }

    public static void print(String text) {
        System.out.println(text);
    }
}