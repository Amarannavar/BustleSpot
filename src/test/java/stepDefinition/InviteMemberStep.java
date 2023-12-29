package stepDefinition;

import org.openqa.selenium.WebDriver;

import PageObject.InviteMembersComponents;
import Utility.CommonHelper;
import io.cucumber.java.en.And;

public class InviteMemberStep {

	WebDriver driver;
	public InviteMembersComponents invite;

	public InviteMemberStep() {
		driver = CommonHelper.driver;
		invite = new InviteMembersComponents(driver);
	}

	@And("invite user with {string} and {string}")
	public void invite_user_with_and(String emailAddress, String role) {
		invite.inviteMember(emailAddress, role);
	}

	@And("invite user with {string}")
	public void invites(String emailId) {
		invite.members(emailId);
	}

	@And("Delete the invited {string}")
	public void deleteInvitation(String emailId) {
		invite.deleteInvite(emailId);
	}

	@And("resend the invitation {string}")
	public void resendInvitation(String emailId) {
		invite.reInvite(emailId);
	}

}
