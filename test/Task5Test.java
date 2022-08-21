import com.epam.khimii.task5.chain.DefaultFilter;
import com.epam.khimii.task5.chain.FileDateFilter;
import com.epam.khimii.task5.chain.FileExtensionFilter;
import com.epam.khimii.task5.chain.FileNameFilter;
import com.epam.khimii.task5.chain.FileSizeFilter;
import com.epam.khimii.task5.chain.IFilter;
import com.epam.khimii.task5.readFileWrapper.ReadTextFileWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Task5Test {
    ReadTextFileWrapper readTextFileWrapper;
    // here my file was in local project
    File file = new File("D:\\epam\\LabMain\\file1.txt");
    private final IFilter filter = new DefaultFilter();

    @Before
    public void beforeTest() {
        readTextFileWrapper = new ReadTextFileWrapper("file1.txt");
    }

    @Test
    public void findByNameAndExtensionTest() {
        FileNameFilter fileNameFilter = new FileNameFilter("file1", filter);
        Assert.assertTrue(fileNameFilter.handle(file));
    }

    @Test
    public void findByExtensionTest() {
        FileExtensionFilter fileExtensionFilter = new FileExtensionFilter("txt", filter);
        Assert.assertTrue(fileExtensionFilter.handle(file));
    }

    @Test
    public void findBySizeTest() {
        FileSizeFilter fileSizeFilter = new FileSizeFilter((int) file.length(), (int) file.length(), filter);
        Assert.assertTrue(fileSizeFilter.handle(file));
    }

    @Test
    public void findByDateTest() throws ParseException {
        String firstDate = "10-08-2022";
        String secondDate = "19-08-2022";
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        Date dateBefore = s.parse(firstDate);
        Date dateAfter = s.parse(secondDate);
        FileDateFilter fileDateFilter = new FileDateFilter(dateBefore, dateAfter, filter);
        Assert.assertTrue(fileDateFilter.handle(file));
    }
}

