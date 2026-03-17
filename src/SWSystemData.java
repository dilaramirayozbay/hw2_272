import java.util.ArrayList;
import java.util.HashMap;

public class SWSystemData {

    public static HashMap<String, ArrayList<SWSystem>> getAllSystems() {

        HashMap<String, ArrayList<SWSystem>> map = new HashMap<>();

        ArrayList<SWSystem> webList = new ArrayList<>();
        webList.add(createECommercePlatform());
        map.put("Web", webList);

        return map;
    }

    private static SWSystem createECommercePlatform() {

        SWSystem s = new SWSystem("ShopSphere", "Web", "3.2.1");

        QualityDimension fs = new QualityDimension("Functional Suitability", "QC.FS", 25);
        fs.addCriterion(new Criterion("Functional Completeness Ratio", 50, "higher", 0, 100, "%"));
        fs.addCriterion(new Criterion("Functional Correctness Ratio", 50, "higher", 0, 100, "%"));
        s.addDimension(fs);

        QualityDimension re = new QualityDimension("Reliability", "QC.RE", 25);
        re.addCriterion(new Criterion("Availability Ratio", 50, "higher", 95, 100, "%"));
        re.addCriterion(new Criterion("Defect Density", 50, "lower", 0, 20, "defect/KLOC"));
        s.addDimension(re);

        QualityDimension pe = new QualityDimension("Performance Efficiency", "QC.PE", 25);
        pe.addCriterion(new Criterion("Response Time", 50, "lower", 0, 500, "ms"));
        pe.addCriterion(new Criterion("CPU Utilisation", 50, "lower", 0, 100, "%"));
        s.addDimension(pe);

        QualityDimension ma = new QualityDimension("Maintainability", "QC.MA", 25);
        ma.addCriterion(new Criterion("Test Coverage Ratio", 50, "higher", 0, 100, "%"));
        ma.addCriterion(new Criterion("Cyclomatic Complexity", 50, "lower", 0, 20, "score"));
        s.addDimension(ma);

        return s;
    }
}