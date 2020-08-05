import org.junit.Assert;
import org.junit.Test;

public class FixedArraySizeQueueTest {

  @Test
  public void test() {
    FixedArraySizeQueue fixedArraySizeQueue = new FixedArraySizeQueue(10);
    fixedArraySizeQueue.enqueue("1");
    fixedArraySizeQueue.enqueue("2");
    fixedArraySizeQueue.enqueue("3");

    Assert.assertEquals("1", fixedArraySizeQueue.dequeue());
  }

  @Test(expected = RuntimeException.class)
  public void testRunTimeexception() {
    FixedArraySizeQueue fixedArraySizeQueue = new FixedArraySizeQueue(10);
    fixedArraySizeQueue.dequeue();
  }

  @Test
  public void testCornerEnque() {
    FixedArraySizeQueue fixedArraySizeQueue = new FixedArraySizeQueue(10);
    fixedArraySizeQueue.enqueue("1");
    fixedArraySizeQueue.enqueue("2");
    fixedArraySizeQueue.enqueue("3");
    fixedArraySizeQueue.enqueue("4");
    fixedArraySizeQueue.enqueue("5");
    fixedArraySizeQueue.enqueue("6");
    fixedArraySizeQueue.enqueue("7");
    fixedArraySizeQueue.enqueue("8");
    fixedArraySizeQueue.enqueue("9");
    fixedArraySizeQueue.enqueue("10");


    Assert.assertEquals("1", fixedArraySizeQueue.dequeue());
    Assert.assertEquals("2", fixedArraySizeQueue.dequeue());
    Assert.assertEquals("3", fixedArraySizeQueue.dequeue());
    Assert.assertEquals("4", fixedArraySizeQueue.dequeue());
    Assert.assertEquals("5", fixedArraySizeQueue.dequeue());
    Assert.assertEquals("6", fixedArraySizeQueue.dequeue());
    Assert.assertEquals("7", fixedArraySizeQueue.dequeue());
    Assert.assertEquals("8", fixedArraySizeQueue.dequeue());
    Assert.assertEquals("9", fixedArraySizeQueue.dequeue());
    Assert.assertEquals("10", fixedArraySizeQueue.dequeue());

    fixedArraySizeQueue.enqueue("11");
    fixedArraySizeQueue.enqueue("12");

    Assert.assertEquals("11", fixedArraySizeQueue.dequeue());
    Assert.assertEquals("12", fixedArraySizeQueue.dequeue());
  }
}
