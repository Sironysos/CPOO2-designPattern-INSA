package exercises.exercise14;

import org.jetbrains.annotations.TestOnly;

public class TestDrawing {
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
}
