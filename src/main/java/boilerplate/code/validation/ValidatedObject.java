package boilerplate.code.validation;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ValidatedObject {

    // @NotNull(message="ID must be auto-generated")
    private String id;

    @NotEmpty(message="")
    @Size(min=3, max=60, message="")
    private String firstName;

    @NotEmpty(message="")
    @Size(min=2, max=60, message="")
    private String lastName;

    @PastOrPresent(message = "")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @Min(value = 1500, message = "")
    @Max(value = 100000, message = "")
    private int salary;

    @Email(message = "")
    @NotBlank(message = "")
    private String email;

    @Pattern(regexp = "[89][0-9]{7}$", message="")
    private String phone;

    @Digits(fraction = 0, integer = 6, message = ".")
    @Min(value = 111111, message = "")
    @Max(value = 999999, message = "")
    private int postalCode;

    public ValidatedObject(String firstName, String lastName, LocalDate dob, int salary, String email, String phone, int postalCode) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
        this.postalCode = postalCode;
    }

    public ValidatedObject() {
    }

    @Override
    public String toString() {
        return "ValidatedObject [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
                + ", salary=" + salary + ", email=" + email + ", phone=" + phone + ", postalCode=" + postalCode + "]";
    }

    
}
