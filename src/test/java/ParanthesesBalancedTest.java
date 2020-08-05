import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParanthesesBalancedTest {

  @Test
  public void testParanteses() {
    Assert.assertTrue(ParanthesesBalanced.isBalanced("[({})]"));
  }


}
