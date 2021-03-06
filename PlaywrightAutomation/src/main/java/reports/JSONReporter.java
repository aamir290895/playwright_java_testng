package reports;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class JSONReporter implements IReporter  {

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
		
		JSONArray results = new JSONArray();
		suites.forEach(element -> {
			results.put(createSuiteJsonObject(element));
		});
		try (FileWriter file = new FileWriter(outputDirectory + "/report.json")) {
			file.write(results.toString());
		} catch (IOException e) {
			System.out.println("Found Exception:" + e);
			
		}
	}

	public JSONObject createSuiteJsonObject(ISuite suite) {
		JSONObject result = new JSONObject();
		JSONArray passedMethods = new JSONArray();
		JSONArray failedMethods = new JSONArray();
		JSONArray skippedMethods = new JSONArray();
		suite.getResults().entrySet().forEach(element -> {
			ITestContext context = element.getValue().getTestContext();
			passedMethods.putAll(createResultJsonArray(context.getPassedTests().getAllResults()));
			failedMethods.putAll(createResultJsonArray(context.getFailedTests().getAllResults()));
			skippedMethods.putAll(createResultJsonArray(context.getSkippedTests().getAllResults()));
		});
		result.put("name", suite.getName());
		result.put("passed", passedMethods);
		result.put("failed", failedMethods);
		result.put("skipped", skippedMethods);
		return result;
	}

	public JSONArray createResultJsonArray(Set<ITestResult> allResults) {
		JSONArray result = new JSONArray();
        allResults.forEach(element ->{
            JSONObject currentJsonResult = new JSONObject();
            currentJsonResult.put("name", element.getName());
            currentJsonResult.put("passed", element.getStatus());
            currentJsonResult.put("failed", element.getStatus());
            currentJsonResult.put("skipped", element.getSkipCausedBy());
            result.put(currentJsonResult);
        });
        return result;
	}

}
