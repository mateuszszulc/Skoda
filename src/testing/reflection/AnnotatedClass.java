package testing.reflection;

import testing.annotations.MyAnnotationField;
import testing.annotations.MyAnnotationMethod;
import testing.annotations.MyAnnotationType;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 25.02.12
 * Time: 23:14
 */

@MyAnnotationType
public class AnnotatedClass {

    @MyAnnotationField
    public String napis;

    public AnnotatedClass(String napis2) {
        setNapis(napis2);
    }

    @MyAnnotationMethod
    public void setNapis(String napis2) {
        napis = napis2;
    }

    public String getNapis() {
        System.out.println(napis);
        return napis;
    }


}
