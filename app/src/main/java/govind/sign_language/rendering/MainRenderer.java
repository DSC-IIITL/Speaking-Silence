package govind.sign_language.rendering;

import java.util.ArrayList;

import govind.sign_language.processing.DetectionMethod;
import govind.sign_language.imaging.IFrame;

public class MainRenderer implements IRenderer {

    private ArrayList<IRenderer> renderers = new ArrayList<>();

    public MainRenderer(DetectionMethod method) {
        setRenderers(method);
    }

    public void display(IFrame inputFrame) {

        for (IRenderer renderer : renderers){
            renderer.display(inputFrame);
        }

    }

    private void setRenderers(DetectionMethod method) {
        switch (method){
            case CANNY_EDGES:
                renderers.add(new CannyEdgesRenderer());
                break;
            case CONTOUR_MASK:
                renderers.add(new ContourMaskRenderer());
                break;
            case SKELETON:
                renderers.add(new SkeletonRenderer());
                break;
            default:
                break;
        }

    }

}
