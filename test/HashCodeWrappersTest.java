import com.epam.khimii.task3.hashCodeWrappers.StringLengthHashCodeWrapper;
import com.epam.khimii.task3.hashCodeWrappers.StringSumElementsHashCodeWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashCodeWrappersTest {

    String product10, product11;

    @Before
    public void BeforeTest() {
        product10 = "Product10";
        product11 = "Product11";
    }

    @Test
    public void StringLengthHashCodeTest() {
        StringLengthHashCodeWrapper lengthWrapper = new StringLengthHashCodeWrapper(product10);
        Assert.assertEquals(9, lengthWrapper.hashCode());
    }

    @Test
    public void StringSumElementsHashCodeTest() {
        StringSumElementsHashCodeWrapper sumWrapper = new StringSumElementsHashCodeWrapper(product10);
        Assert.assertEquals(405, sumWrapper.hashCode());
    }

    @Test
    public void StringLengthEqualsTest() {
        StringLengthHashCodeWrapper wrapper = new StringLengthHashCodeWrapper(product10);
        StringLengthHashCodeWrapper lengthWrapper2 = new StringLengthHashCodeWrapper(product10);
        StringLengthHashCodeWrapper lengthWrapper3 = new StringLengthHashCodeWrapper(product11);

        Assert.assertTrue(wrapper.equals(lengthWrapper2));
        Assert.assertFalse(wrapper.equals(lengthWrapper3));
    }


    @Test
    public void StringSumEqualsTest() {
        StringSumElementsHashCodeWrapper sumWrapper = new StringSumElementsHashCodeWrapper(product10);
        StringSumElementsHashCodeWrapper sumWrapper2 = new StringSumElementsHashCodeWrapper(product10);
        StringSumElementsHashCodeWrapper sumWrapper3 = new StringSumElementsHashCodeWrapper(product11);

        Assert.assertTrue(sumWrapper.equals(sumWrapper2));
        Assert.assertFalse(sumWrapper.equals(sumWrapper3));
    }
}
