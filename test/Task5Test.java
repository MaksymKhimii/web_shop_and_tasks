import com.epam.khimii.task5.chain.FileDateFilter;
import com.epam.khimii.task5.chain.FileExtensionFilter;
import com.epam.khimii.task5.chain.FileNameFilter;
import com.epam.khimii.task5.chain.FileSizeFilter;
import com.epam.khimii.task5.container.ParametersContainer;
import com.epam.khimii.task5.readFileWrapper.ReadTextFileWrapper;
import com.epam.khimii.task5.searchingFiles.FileFilterByParameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task5Test {
    ReadTextFileWrapper readTextFileWrapper;
    ParametersContainer parametersContainer;
    FileFilterByParameters fileFilterByParameters;
    List<File> allFiles;
    // here my file was in local project
    File file = new File("D:\\epam\\LabMain\\file1.txt");
    List<File> expected;

    @Before
    public void beforeTest() {
        readTextFileWrapper = new ReadTextFileWrapper("file1.txt");
        expected = new ArrayList<>();
        expected.add(file);
        parametersContainer = new ParametersContainer();
        fileFilterByParameters = new FileFilterByParameters();
        allFiles = fileFilterByParameters.getAllFiles("D:\\epam\\LabMain\\");
    }

    @Test
    public void findByNameAndExtensionTest() {
        FileNameFilter fileNameFilter = new FileNameFilter("file1");
        Assert.assertEquals(expected, fileNameFilter.handle(allFiles));
    }

    @Test
    public void findByExtensionTest() {
        FileExtensionFilter fileExtensionFilter = new FileExtensionFilter("txt");
        Assert.assertEquals(expected, fileExtensionFilter.handle(allFiles));
    }

    @Test
    public void findBySizeTest() {
        FileSizeFilter fileSizeFilter = new FileSizeFilter((int) file.length(), (int) file.length());
        Assert.assertEquals(expected, fileSizeFilter.handle(allFiles));
    }

    @Test
    public void findByDateTest() throws ParseException {
        String firstDate = "10-08-2022";
        String secondDate = "11-08-2022";
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date dateBefore = s.parse(firstDate);
        Date dateAfter = s.parse(secondDate);
        FileDateFilter fileDateFilter = new FileDateFilter(dateBefore, dateAfter);
        ArrayList<File> exp = new ArrayList<>();
        Assert.assertEquals(exp, fileDateFilter.handle(allFiles));
    }
}

