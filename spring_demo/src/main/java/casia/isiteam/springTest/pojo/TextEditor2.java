package casia.isiteam.springTest.pojo;

/**
 * @ClassName: TextEditor2
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/21
 * Email: zhiyou_wang@foxmail.com
 */
public class TextEditor2 {
    private SpellChecker2 spellChecker;
    // a setter method to inject the dependency.
    public void setSpellChecker(SpellChecker2 spellChecker) {
        System.out.println("Inside 2 setSpellChecker." );
        this.spellChecker = spellChecker;
    }
    // a getter method to return spellChecker
    public SpellChecker2 getSpellChecker() {
        return spellChecker;
    }
    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
