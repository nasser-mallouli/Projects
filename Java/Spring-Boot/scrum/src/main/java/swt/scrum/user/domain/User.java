package swt.scrum.user.domain;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private UUID id = UUID.randomUUID();
    private String name;
    private String email;
    private String password;
    private Data RegisteredDate;

    public User( String name, String email, String password, Data registeredDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        RegisteredDate = registeredDate;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Data getRegisteredDate() {
        return RegisteredDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegisteredDate(Data registeredDate) {
        RegisteredDate = registeredDate;
    }
}
