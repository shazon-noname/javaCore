package Collections.Array.FigureBoard;

public class Figure {
    private final FigureColor figureColor;
    private final FigureType figureType;

    public Figure(FigureColor figureColor, FigureType figureType) {
        this.figureColor = figureColor;
        this.figureType = figureType;
    }

    public FigureColor getFigureColor() {
        return figureColor;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    @Override
    public String toString() {
        return figureColor.toString().substring(0,1) + figureType.toString().substring(0,1);
    }
}
