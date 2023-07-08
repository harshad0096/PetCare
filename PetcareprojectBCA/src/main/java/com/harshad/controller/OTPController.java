package com.harshad.controller;

/* import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harshad.global.EmailTemplate;
import com.harshad.model.User;
import com.harshad.repository.UserRepository;
import com.harshad.service.EmailService;
import com.harshad.service.OTPService;

@Controller
public class OTPController {

	@Autowired
	private OTPService otpService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/generateOtp")
	public String generateOTP() throws MessagingException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		User user = userRepository.findByUsername(username);

		if (user != null && user.getEmail() != null) {
			int otp = otpService.generateOTP(username);

			// Generate The Template to send OTP
			EmailTemplate template = new EmailTemplate("SendOtp.html");
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("user", username);
			replacements.put("otpnum", String.valueOf(otp));
			String message = template.getTemplate(replacements);

			emailService.sendOtpMessage(user.getEmail(), "OTP - Pet Care App",
					"Your Pet Care App verification OTP is: " + otp);

			return "otpvalid";
		} else {
			return "redirect:/login";
		}

	}

	@RequestMapping(value = "/validateOtp", method = RequestMethod.GET)
	public @ResponseBody String validateOtp(@RequestParam("otpnum") int otpnum) {

		final String SUCCESS = "Entered OTP is valid.";
		final String FAIL = "Entered OTP is NOT valid. Please Retry!";

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		// Validate the OTP
		if (otpnum >= 0) {

			int serverOtp = otpService.getOtp(username);

			if (serverOtp > 0) {
				if (otpnum == serverOtp) {
					otpService.clearOTP(username);

					JSONObject jsonObject = new JSONObject();
					jsonObject.put("status", "success");
					jsonObject.put("message", SUCCESS);
					return jsonObject.toString();
				} else {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("status", "fail");
					jsonObject.put("message", FAIL);
					return jsonObject.toString();
				}
			}
		}
		return "/";
	}
}*/
