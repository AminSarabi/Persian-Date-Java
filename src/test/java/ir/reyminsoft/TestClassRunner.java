package ir.reyminsoft;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ir.reyminsoft.Utils.stringify;

public class TestClassRunner {
    public static void assertEquals(final Object o, final Object o2) {
        if (!Utils.equals(o, o2))
            throw new RuntimeException("assertion error: '" + stringify(o) + "' != '" + stringify(o2) + "'");
    }

    public static void assertEquals(final Object o, final Object o2, String message) {
        if (!Utils.equals(o, o2))
            throw new RuntimeException("assertion error: '" + stringify(o) + "' != '" + stringify(o2) + "' \n" + message);
    }

    public static void print(final String str) {
        System.out.println(str);
    }

    public static void run(final Class<? extends TestClass> cls) {
        final Method[] methods = cls.getDeclaredMethods();
        final List<Method> methodList = new ArrayList<>();
        boolean onlyAnnotatedTests = false;
        for (final Method method : methods) {
            if (method.getParameterCount() == 0 && method.getReturnType() == Void.TYPE) {
                if (method.isAnnotationPresent(ThisTestOnly.class)) {
                    onlyAnnotatedTests = true;
                    run(method);
                } else {
                    methodList.add(method);
                }

            }
        }
        methodList.sort(Comparator.comparing(Method::getName));
        if (!onlyAnnotatedTests)
            for (final Method method : methodList) {
                if (Modifier.isStatic(method.getModifiers())) {
                    run(method);
                }

            }
    }

    private static void run(Method method) {
        if (method.getParameterCount() == 0) {
            try {
                print("running " + method.getName());
                method.invoke(null);
                print(method.getName() + " passed!");
            } catch (final Throwable e) {
                print(method.getName() + " failed:");
                final StringWriter stringWriter = new StringWriter();
                final PrintWriter printWriter = new PrintWriter(stringWriter);
                e.printStackTrace(printWriter);
                print("stack printed:\n" + stringWriter);
            } finally {
                print("-------------------------------------");
            }
        }
    }
}
