package exercises.exercise14;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.TestOnly;

import ch.qos.logback.core.joran.action.Action;

/* public class TestDrawingNew {
  Canvas drawingArea;
    // ...

    @Test
    public void testRectangleCreated() {
        //SelectRectanfgleMode: Selecting the editing mode RECTANGLE
        canvas.setEditingMode(EditingMode.RECTANGLE);

        //DnD2DrawRectangle: Executing the drag-and-drop on the drawing area
        Robot.moveTo(Robot.getRandomPointIn(drawingArea));
        Robot.press();
        Robot.moveTo(Robot.getRandomPointIn(drawingArea));
        Robot.release();
    } 
}*/

// Ce qu'il y a au dessus c'est nul, il y a du code duppliqué
// On va plutôt utiliser les patrons de conception commande et composite

//interface Action
public interface Action {
    void run();
}
class CompositeAction implements Action {
    List<Action> actions;
    @Override
    public void run() {
        actions.forEach(action -> action.run());
    }
    public static CompositeAction of(Action... actions) {
        return new CompositeAction(actions);
    }
}


class TestDrawingNew {
    Canvas drawingArea;
    // ...

    Action selectRectangleMode = () -> {
        drawingArea.setEditingMode(EditingMode.RECTANGLE);
    };

    Action dnd2DrawRectangle = () -> {
        Robot.moveTo(Robot.getRandomPointIn(drawingArea));
        Robot.press();
        Robot.moveTo(Robot.getRandomPointIn(drawingArea));
        Robot.release();
    };

    @Test
    public void testRectangleCreated() {
        // fixture et exécution du scénario
        CompositeAction.of(selectRectangleMode, dnd2DrawRectangle).run();
        //assertions
        assertEquals(/*  */);
    }
}
