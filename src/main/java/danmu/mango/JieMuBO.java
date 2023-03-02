package danmu.mango;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JieMuBO {
    private String title;
    private int duration;
    private String danMuUrlPatten;
    private String videoId;
}
