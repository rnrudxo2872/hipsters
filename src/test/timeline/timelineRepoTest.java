import com.dosters.timeline.domain.timelineEntity;
import com.dosters.timeline.repository.timelineRepo;

import org.springframework.beans.factory.annotation.Autowired;

import antlr.collections.List;
import jdk.jfr.Timestamp;

public class timelineRepoTest extends JpatestApplicationTests{
    
@Autowired
private timelineRepo timelineRepo;

@Test
public void create(){
    timelineEntity tl = new timelineEntity();

    tl.setId("nani");
    tl.setContent("그지같네");

    timelineRepo.save(tl);


}

}
