package hus.cisk62.demo.routers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@Getter
public class SaveForm {
    private int id;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    private String reason;
    private String description;
    private Timestamp createAt;
}
