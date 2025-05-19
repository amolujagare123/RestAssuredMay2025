package POJO.chatserver;

public class CreateUserChatServerPOJO {

    String username;
    String password;
    String name;
    String surname;
    String email;
    String chat_nickname;
    int[] departments;
    int[] departments_read;
    int[] department_groups;
    int[] user_groups;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChat_nickname() {
        return chat_nickname;
    }

    public void setChat_nickname(String chat_nickname) {
        this.chat_nickname = chat_nickname;
    }

    public int[] getDepartments() {
        return departments;
    }

    public void setDepartments(int[] departments) {
        this.departments = departments;
    }

    public int[] getDepartments_read() {
        return departments_read;
    }

    public void setDepartments_read(int[] departments_read) {
        this.departments_read = departments_read;
    }

    public int[] getDepartment_groups() {
        return department_groups;
    }

    public void setDepartment_groups(int[] department_groups) {
        this.department_groups = department_groups;
    }

    public int[] getUser_groups() {
        return user_groups;
    }

    public void setUser_groups(int[] user_groups) {
        this.user_groups = user_groups;
    }
}
