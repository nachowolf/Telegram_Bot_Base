package bot.brain.subroutines;

import com.rivescript.RiveScript;
import com.rivescript.macro.Subroutine;

public class ReverseText implements Subroutine {
    @Override
    public String call(RiveScript riveScript, String[] strings) {
        String user = riveScript.currentUser();
        String word = riveScript.getUservar(user, "reverseWord");
        return new StringBuilder(word).reverse().toString();
    }
}
