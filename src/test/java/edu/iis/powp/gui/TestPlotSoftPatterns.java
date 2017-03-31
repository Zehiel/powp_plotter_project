package edu.iis.powp.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.iis.client.plottermagic.ClientPlotter;
import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.adapter.LinePlotterAdapter;
import edu.iis.powp.adapter.PlotterAdapter;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.Context;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.appext.ApplicationWithDrawer;
import edu.iis.powp.events.predefine.SelectChangeVisibleOptionListener;
import edu.iis.powp.events.predefine.SelectTestFigureOptionListener;
import edu.kis.powp.drawer.panel.DefaultDrawerFrame;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.LineFactory;


public class TestPlotSoftPatterns {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Setup test concerning preset figures in context.
     *
     * @param context Application context.
     */
    private static void setupPresetTests(Context context) {
        SelectTestFigureOptionListener selectTestFigureOptionListenerScript1 = new SelectTestFigureOptionListener(1);
        SelectTestFigureOptionListener selectTestFigureOptionListenerScript2 = new SelectTestFigureOptionListener(2);


        context.addTest("Figure Joe 1", selectTestFigureOptionListenerScript1);
        context.addTest("Figure Joe 2", selectTestFigureOptionListenerScript2);

    }

    /**
     * Setup driver manager, and set default IPlotter for application.
     *
     * @param context Application context.
     */
    private static void setupDrivers(Context context) {
        IPlotter clientPlotter = new ClientPlotter();
        context.addDriver("Client Plotter", clientPlotter);
        Application.getComponent(DriverManager.class).setCurrentPlotter(clientPlotter);

        IPlotter plotSimulator = new PlotterAdapter(ApplicationWithDrawer.getDrawPanelController());
        context.addDriver("Bug free simulator", plotSimulator);

        //TODO UI Way of changing line type
        IPlotter linePlotSimulator = new LinePlotterAdapter(ApplicationWithDrawer.getDrawPanelController(), LineFactory.getDottedLine());
        context.addDriver("Line plot simulator", linePlotSimulator);


        context.updateDriverInfo();
    }

    /**
     * Auxiliary routines to enable using Buggy Simulator.
     *
     * @param context Application context.
     */
    private static void setupDefaultDrawerVisibilityManagement(Context context) {
        DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
        context.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
                new SelectChangeVisibleOptionListener(defaultDrawerWindow), false);
        defaultDrawerWindow.setVisible(false);
    }

    /**
     * Setup menu for adjusting logging settings.
     *
     * @param context Application context.
     */
    private static void setupLogger(Context context) {
        Application.addComponent(Logger.class);
        context.addComponentMenu(Logger.class, "Logger", 0);
        context.addComponentMenuElement(Logger.class, "Clear log", (ActionEvent e) -> context.flushLoggerOutput());
        context.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> LOGGER.setLevel(Level.FINE));
        context.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> LOGGER.setLevel(Level.INFO));
        context.addComponentMenuElement(Logger.class, "Warning level", (ActionEvent e) -> LOGGER.setLevel(Level.WARNING));
        context.addComponentMenuElement(Logger.class, "Severe level", (ActionEvent e) -> LOGGER.setLevel(Level.SEVERE));
        context.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> LOGGER.setLevel(Level.OFF));
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationWithDrawer.configureApplication();
                Context context = Application.getComponent(Context.class);

                setupDefaultDrawerVisibilityManagement(context);

                setupDrivers(context);
                setupPresetTests(context);
                setupLogger(context);
            }

        });
    }

}
