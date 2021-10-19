package mvc;


import mvc.interfaces.Model;
import mvc.interfaces.View;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import reflection.ComplexValue;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @Mock
    private Model model;

    @Mock
    private View view;

    @InjectMocks
    private ValueController controller;

    private void initValuesData(String answer){
        doReturn(answer).when(view).getInformation("What do you want to do?");
        doReturn("0").when(view).getInformation(or(eq("\t\tType real part:"), eq("\t\tType imaginary part:")));
    }

    @Test
    public void testControllerProcessingSumming(){
        initValuesData("add values");
        doReturn(new ComplexValue(8, 8)).when(model).addValues(any(), any());
        controller.process();
        verify(model, times(2)).createValue(anyDouble(), anyDouble());
        verify(model).addValues(any(), any());
        verify(view, times(3)).printInformation(anyString());
    }

    @Test
    public void testControllerProcessingSubtracting(){
        initValuesData("subtract values");
        doReturn(new ComplexValue(0, 0)).when(model).subtractValues(any(), any());
        controller.process();
        verify(model, times(2)).createValue(anyDouble(), anyDouble());
        verify(model).subtractValues(any(), any());
        verify(view, times(3)).printInformation(anyString());
    }

    @Test
    public void testControllerProcessingMultiplying(){
        initValuesData("multiply values");
        doReturn(new ComplexValue(0, 0)).when(model).multiplyValues(any(), any());
        controller.process();
        verify(model, times(2)).createValue(anyDouble(), anyDouble());
        verify(model).multiplyValues(any(), any());
        verify(view, times(3)).printInformation(anyString());
    }

    @Test
    public void testControllerProcessingDividing(){
        initValuesData("divide values");
        doReturn(new ComplexValue(0, 0)).when(model).divideValues(any(), any());
        controller.process();
        verify(model, times(2)).createValue(anyDouble(), anyDouble());
        verify(model).divideValues(any(), any());
        verify(view, times(3)).printInformation(anyString());
    }

    @Test
    public void testControllerProcessingGettingSuperClassName(){
        doReturn("get superclass").when(view).getInformation("What do you want to do?");
        controller.process();
        verify(model, times(1)).getSuperClassSimpleName();
    }

    @Test
    public void testControllerProcessingGettingClassName(){
        doReturn("get class").when(view).getInformation("What do you want to do?");
        controller.process();
        verify(model, times(1)).getClassSimpleName();
    }

    @Test
    public void testControllerProcessingGettingClassPackage(){
        doReturn("get package").when(view).getInformation("What do you want to do?");
        controller.process();
        verify(model, times(1)).getPackageName();
    }

    @Test
    public void testControllerProcessingGettingMethodsInfo(){
        doReturn("get methods").when(view).getInformation("What do you want to do?");
        controller.process();
        verify(model, times(1)).getMethodInfo();
    }

    @Test
    public void testControllerProcessingInvokingMethods(){
        doReturn("invoke methods").when(view).getInformation("What do you want to do?");
        controller.process();
        verify(model, times(1)).invokeAnnotatedMethods();
    }

}
