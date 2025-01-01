import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumberGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args) {
        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        Executor codeToExecute = () -> System.out.println("Say");
        processor.execute(codeToExecute);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("Testing poem beautifier: ");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String text1 = "Lorem ipsum";
        String text2 = "Another lorem ipsum";
        String text3 = "Yet another lorem ipsum";
        String text4 = "Final lorem ipsum";
        poemBeautifier.beautify(text1, poem -> poem.toLowerCase());
        poemBeautifier.beautify(text2, poem -> "ABC " + poem + " ABC");
        poemBeautifier.beautify(text3, poem -> poem.toUpperCase());
        poemBeautifier.beautify(text4, poem -> "\n----------\n" + poem + "\n---------");

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumberGenerator.generateEven(20);
    }
}
