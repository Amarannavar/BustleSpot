package stepDefinition;

import org.openqa.selenium.WebDriver;
import PageObject.TasksPageComponent;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class CreateEditDeleteTasksStep {
	WebDriver driver;
	public TasksPageComponent tasks;

	public CreateEditDeleteTasksStep() {
		driver = CommonHelper.driver;
		tasks = new TasksPageComponent(driver);
	}

	@When("create new {string}")
	public void new_task(String taskname) {
		tasks.createTask(taskname);
	}
	
	@And("delete the {string}")
	public void deleteTasks(String taskname) {
		tasks.deleteTask(taskname);
	}
	
	@And("edit the {string} and verify {string}")
	public void editTasks(String taskname,String validationText) {
		tasks.editTask(taskname,validationText);
	}
}
