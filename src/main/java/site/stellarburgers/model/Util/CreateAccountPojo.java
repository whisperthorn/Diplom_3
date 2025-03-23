package site.stellarburgers.model.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountPojo {
    private String email;
    private String password;
    private String name;
}