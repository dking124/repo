import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Darren King
 *
 */
public final class PasswordCheckerUtility {
	/**
	 * No-arg constructor
	 */
	public PasswordCheckerUtility() {
		
	}
	/**
	 * Method that checks if given password is valid
	 * @param passwordString
	 * @return valid
	 * @throws LengthException thrown if password is less than 6 characters
	 * @throws NoDigitException thrown if password contains no digits
	 * @throws NoUpperAlphaException thrown if password contains no uppercase character
	 * @throws NoLowerAlphaException thrown if password contains no lowercase character
	 * @throws NoSpecialSymbolException thrown if password contains no special symbol
	 * @throws InvalidSequenceException thrown if password contains a character that is consecutively used 3 times
	 */
	public static boolean isValidPassword(String passwordString) 
			throws LengthException, NoDigitException, NoUpperAlphaException, 
			NoLowerAlphaException, NoSpecialSymbolException, InvalidSequenceException{
		
		boolean valid = true;
		// Checking if password is valid
		if (checkPasswordLength(passwordString) == false) {
			valid = false;
			throw new LengthException();
		}
		else if (checkUpperCase(passwordString) == false) {
			valid = false;
			throw new NoUpperAlphaException();
		}
		else if (checkLowerCase(passwordString) == false) {
			valid = false;
			throw new NoLowerAlphaException();
		}
		else if (checkDigit(passwordString) == false) {
			valid = false;
			throw new NoDigitException();
		}
		else if (checkSpecial(passwordString) == false) {
			valid = false;
			throw new NoSpecialSymbolException();
		}
		else if (checkSequence(passwordString) == false) {
			valid = false;
			throw new InvalidSequenceException();
		}
		
		return valid;
	}
	/**
	 * Method that checks if password is weak (6-9 characters long)
	 * @param passwordString
	 * @return weak
	 */
	public static boolean isWeakPassword(String passwordString) {
		boolean weak = false;
		if (passwordString.length() >= 6 && passwordString.length() <= 9) {
			weak = true;
		}
		return weak;
	}
	/**
	 * Method that 
	 * @param passwords
	 * @return
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> invalid = new ArrayList<String>();
		for (int i = 0; i < passwords.size(); i++) {
			try {
				isValidPassword(passwords.get(i));
			}
			catch(LengthException e) {
				invalid.add(passwords.get(i) + " " + e.getMessage());
			}
			catch(NoUpperAlphaException e) {
				invalid.add(passwords.get(i) + " " + e.getMessage());
			}
			catch(NoLowerAlphaException e) {
				invalid.add(passwords.get(i) + " " + e.getMessage());
			}
			catch(NoDigitException e) {
				invalid.add(passwords.get(i) + " " + e.getMessage());
			}
			catch(NoSpecialSymbolException e) {
				invalid.add(passwords.get(i) + " " + e.getMessage());
			}
			catch(InvalidSequenceException e) {
				invalid.add(passwords.get(i) + " " + e.getMessage());
			}
		}
		return invalid;
	}
	/**
	 * Method that checks length of given password
	 * @param passwordString
	 * @return valid
	 */
	public static boolean checkPasswordLength(String passwordString) {
		boolean valid = true;
		if (passwordString.length() < 6) {
			valid = false;
		}
		return valid;
	}
	/**
	 * Method that checks if given password contains a digit
	 * @param passwordString
	 * @return valid
	 */
	public static boolean checkDigit(String passwordString) {
		boolean valid = false;
		for (int i = 0; i < passwordString.length(); i++) {
			char a = passwordString.charAt(i);
			if (Character.isDigit(a)) {
				valid = true;
			}
		}
		return valid;
	}
	/**
	 * Method that checks if given password
	 * contains a uppercase character
	 * @param passwordString
	 * @return valid
	 */
	public static boolean checkUpperCase(String passwordString) {
		boolean valid = false;
		for (int i = 0; i < passwordString.length(); i++) {
			char a = passwordString.charAt(i);
			if (Character.isUpperCase(a)) {
				valid = true;
			}
		}
		return valid;
	}
	/**
	 * Method that checks if given password
	 * contains a lowercase character
	 * @param passwordString
	 * @return valid
	 */
	public static boolean checkLowerCase(String passwordString) {
		boolean valid = false;
		for (int i = 0; i < passwordString.length(); i++) {
			char a = passwordString.charAt(i);
			if (Character.isLowerCase(a)) {
				valid = true;
			}
		}
		return valid;
	}
	/**
	 * Method that checks if given password
	 * contains a special character
	 * @param passwordString
	 * @return valid
	 */
	public static boolean checkSpecial(String passwordString) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(passwordString);
		return (!matcher.matches());
	}
	/**
	 * Method that checks if given password
	 * contains a character that repeats 3
	 * times in a row
	 * @param passwordString
	 * @return valid
	 */
	public static boolean checkSequence(String passwordString) {
		boolean valid = true;
		for (int i = 2; i < passwordString.length(); i++) {
			if (passwordString.charAt(i) == passwordString.charAt(i-1) && passwordString.charAt(i) == passwordString.charAt(i-2)) {
				valid = false;
			}
		}
		return valid;
	}
}
