package p06_TirePressureMonitoring;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlarmTest {

    private static final Sensor sensor = Mockito.mock(Sensor.class);
    private static Alarm alarm;

    @Before
    public void setUp(){
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmCheckShouldReturnTrueWhenPressureValueIsLessThenLOW_PRESSURE_THRESHOLD(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(13.3);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmCheckShouldReturnTrueWhenPressureValueIsBiggerThenHIGH_PRESSURE_THRESHOLD(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(27.7);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmCheckShouldReturnFalseWhenPressureValueIsBetweenLOW_PRESSURE_THRESHOLD_And_HIGH_PRESSURE_THRESHOLD(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.8);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testSensorRandomValue(){
        alarm = new Alarm(new Sensor());
        alarm.check();
    }
}
