package ua.nure.shot.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShotContext {

    private ShotGrade shotGrade;

    private ShotType shotType;

    private long crystalCount;
}
