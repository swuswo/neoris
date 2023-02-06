package neoris.api.dtos.create;

public class UsersFactory {

    public UsersDTO requestValue(String names, String job) {
        return new UsersDTO.UsersDTOBuilder()
                .names(names)
                .job(job)
                .build();
    }
}