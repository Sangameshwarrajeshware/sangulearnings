import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InfixParanthesesTest {

  @Test
  public void test() {
    String output = InfixParanthesesByExpert.getInfixExpression("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )");
    System.out.println(output);
    Assert.assertEquals("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )",output);

    String output1 = InfixParantheses.infix("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )");
    System.out.println(output);
    Assert.assertEquals("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )",output);
  }
}
