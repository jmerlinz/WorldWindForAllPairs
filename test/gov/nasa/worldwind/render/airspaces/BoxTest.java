/*
 * Copyright (C) 2019 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration.
 * All Rights Reserved.
 */
package gov.nasa.worldwind.render.airspaces;

import gov.nasa.worldwind.geom.*;
import gov.nasa.worldwind.render.*;
import gov.nasa.worldwind.terrain.Terrain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class BoxTest
{
    @Test
    public void testUnusualDrawBox()
    {
        Box expected = new Box();
        double[] altitudes = {1.0,2.0};
        boolean[] terrainConformant = {true};
        DrawContextImpl dcDummy = new DrawContextImpl();

        Terrain dummyTerrain = null;
        Box.BoxGeometry geomDummy = new Box.BoxGeometry();
        // AbstractAirspace properties
        expected.setVisible(false);
        expected.setHighlighted(true);
        expected.setEnableBatchRendering(false);
        expected.setEnableBatchPicking(false);
        expected.setEnableDepthOffset(true);
        expected.setOutlinePickWidth(31);
        expected.setAlwaysOnTop(true);
        expected.setDrawSurfaceShape(true);
        expected.setEnableLevelOfDetail(false);
        // TrackAirspace properties
//        expected.setEnableInnerCaps(false);
//        expected.setEnableCenterLine(true);
//        expected.setSmallAngleThreshold(Angle.fromDegrees(21));
//        expected.addLeg(LatLon.fromDegrees(1, 2), LatLon.fromDegrees(3, 4), 1, 2, 3, 4);
//        expected.addLeg(LatLon.fromDegrees(3, 4), LatLon.fromDegrees(5, 6), 5, 6, 7, 8);
//        expected.addLeg(LatLon.fromDegrees(5, 6), LatLon.fromDegrees(7, 8), 9, 10, 11, 12);
        expected.makeSideGeometry(dcDummy.getTerrain(), altitudes, terrainConformant, 14,1,geomDummy);
        String stateInXml = expected.getRestorableState();

        Box actual = new Box();
        actual.restoreState(stateInXml);

        assertTrackAirspaceEquals(expected, actual);
    }

    @Test
    public void testNullAttitudeDrawBox()
    {
        Box expected = new Box();
        double[] altitudes = {1.0,2.0};
        boolean[] terrainConformant = {true};
        DrawContextImpl dcDummy = new DrawContextImpl();

        Terrain dummyTerrain = null;
        Box.BoxGeometry geomDummy = new Box.BoxGeometry();
        // AbstractAirspace properties
        expected.setVisible(false);
        expected.setHighlighted(true);
        expected.setEnableBatchRendering(false);
        expected.setEnableBatchPicking(false);
        expected.setEnableDepthOffset(true);
        expected.setOutlinePickWidth(31);
        expected.setAlwaysOnTop(true);
        expected.setDrawSurfaceShape(true);
        expected.setEnableLevelOfDetail(false);
        expected.makeSideGeometry(dcDummy.getTerrain(), null, terrainConformant, 14,1,geomDummy);
        String stateInXml = expected.getRestorableState();

        Box actual = new Box();
        actual.restoreState(stateInXml);

        assertTrackAirspaceEquals(expected, actual);
    }

    @Test
    public void testNullConformantAttitudeDrawBox()
    {
        Box expected = new Box();
        double[] altitudes = {1.0,2.0};
        DrawContextImpl dcDummy = new DrawContextImpl();

        Terrain dummyTerrain = null;
        Box.BoxGeometry geomDummy = new Box.BoxGeometry();
        // AbstractAirspace properties
        expected.setVisible(false);
        expected.setHighlighted(true);
        expected.setEnableBatchRendering(false);
        expected.setEnableBatchPicking(false);
        expected.setEnableDepthOffset(true);
        expected.setOutlinePickWidth(31);
        expected.setAlwaysOnTop(true);
        expected.setDrawSurfaceShape(true);
        expected.setEnableLevelOfDetail(false);
        expected.makeSideGeometry(dcDummy.getTerrain(), altitudes, null, 14,1,geomDummy);
        String stateInXml = expected.getRestorableState();

        Box actual = new Box();
        actual.restoreState(stateInXml);

        assertTrackAirspaceEquals(expected, actual);
    }

    @Test
    public void testNegativeLengthDrawBox()
    {
        Box expected = new Box();
        double[] altitudes = {1.0,2.0};
        boolean[] terrainConformant = {true};
        DrawContextImpl dcDummy = new DrawContextImpl();

        Terrain dummyTerrain = null;
        Box.BoxGeometry geomDummy = new Box.BoxGeometry();
        // AbstractAirspace properties
        expected.setVisible(false);
        expected.setHighlighted(true);
        expected.setEnableBatchRendering(false);
        expected.setEnableBatchPicking(false);
        expected.setEnableDepthOffset(true);
        expected.setOutlinePickWidth(31);
        expected.setAlwaysOnTop(true);
        expected.setDrawSurfaceShape(true);
        expected.setEnableLevelOfDetail(false);
        expected.makeSideGeometry(dcDummy.getTerrain(), altitudes, terrainConformant, -1,1,geomDummy);
        String stateInXml = expected.getRestorableState();

        Box actual = new Box();
        actual.restoreState(stateInXml);

        assertTrackAirspaceEquals(expected, actual);
    }

    @Test
    public void testNegativeWidthDrawBox()
    {
        Box expected = new Box();
        double[] altitudes = {1.0,2.0};
        boolean[] terrainConformant = {true};
        DrawContextImpl dcDummy = new DrawContextImpl();

        Terrain dummyTerrain = null;
        Box.BoxGeometry geomDummy = new Box.BoxGeometry();
        // AbstractAirspace properties
        expected.setVisible(false);
        expected.setHighlighted(true);
        expected.setEnableBatchRendering(false);
        expected.setEnableBatchPicking(false);
        expected.setEnableDepthOffset(true);
        expected.setOutlinePickWidth(31);
        expected.setAlwaysOnTop(true);
        expected.setDrawSurfaceShape(true);
        expected.setEnableLevelOfDetail(false);
        expected.makeSideGeometry(dcDummy.getTerrain(), altitudes, terrainConformant, 5,-1,geomDummy);
        String stateInXml = expected.getRestorableState();

        Box actual = new Box();
        actual.restoreState(stateInXml);

        assertTrackAirspaceEquals(expected, actual);
    }

    @Test
    public void testNullTerrainDrawBox()
    {
        Box expected = new Box();
        double[] altitudes = {1.0,2.0};
        boolean[] terrainConformant = {true};
        DrawContextImpl dcDummy = new DrawContextImpl();

        Terrain dummyTerrain = null;
        Box.BoxGeometry geomDummy = new Box.BoxGeometry();
        expected.makeSideGeometry(dcDummy.getTerrain(), altitudes, terrainConformant, 14,1,geomDummy);
        String stateInXml = expected.getRestorableState();

        Box actual = new Box();
        actual.restoreState(stateInXml);

        assertTrackAirspaceEquals(expected, actual);
    }

    @Test
    public void testValidAppendBox()
    {
        Box expected = new Box();
        double[] altitudes = {1.0,2.0};
        boolean[] terrainConformant = {true};
        DrawContextImpl dcDummy = new DrawContextImpl();

        Terrain dummyTerrain = null;
        Box.BoxGeometry geomDummy = new Box.BoxGeometry();

        List<LatLon> res = new ArrayList<LatLon>();
        expected.appendLocations(LatLon.fromDegrees(1, 2), LatLon.fromDegrees(3, 4), LatLon.fromDegrees(4, 5),4, res);
        String stateInXml = expected.getRestorableState();

        Box actual = new Box();
        actual.restoreState(stateInXml);

        assertTrackAirspaceEquals(expected, actual);
    }

    @Test
    public void testNullFirstLatLonAppendBox()
    {
        Box expected = new Box();
        double[] altitudes = {1.0,2.0};
        boolean[] terrainConformant = {true};
        DrawContextImpl dcDummy = new DrawContextImpl();

        Terrain dummyTerrain = null;
        Box.BoxGeometry geomDummy = new Box.BoxGeometry();

        List<LatLon> res = new ArrayList<LatLon>();
        expected.appendLocations(null, LatLon.fromDegrees(3, 4), LatLon.fromDegrees(4, 5),4, res);
        String stateInXml = expected.getRestorableState();

        Box actual = new Box();
        actual.restoreState(stateInXml);

        assertTrackAirspaceEquals(expected, actual);
    }

    @Test
    public void testZeroSegmentsAppendBox()
    {
        Box expected = new Box();
        double[] altitudes = {1.0,2.0};
        boolean[] terrainConformant = {true};
        DrawContextImpl dcDummy = new DrawContextImpl();

        Terrain dummyTerrain = null;
        Box.BoxGeometry geomDummy = new Box.BoxGeometry();

        List<LatLon> res = new ArrayList<LatLon>();
        expected.appendLocations(LatLon.fromDegrees(1, 2), LatLon.fromDegrees(3, 4), LatLon.fromDegrees(4, 5),0, res);
        String stateInXml = expected.getRestorableState();

        Box actual = new Box();
        actual.restoreState(stateInXml);

        assertTrackAirspaceEquals(expected, actual);
    }

    @Test
    public void testSameLatLonAppendBox()
    {
        Box expected = new Box();
        double[] altitudes = {1.0,2.0};
        boolean[] terrainConformant = {true};
        DrawContextImpl dcDummy = new DrawContextImpl();

        Terrain dummyTerrain = null;
        Box.BoxGeometry geomDummy = new Box.BoxGeometry();

        List<LatLon> res = new ArrayList<LatLon>();
        expected.appendLocations(LatLon.fromDegrees(1, 2), LatLon.fromDegrees(1, 2), LatLon.fromDegrees(4, 5),5, res);
        String stateInXml = expected.getRestorableState();

        Box actual = new Box();
        actual.restoreState(stateInXml);

        assertTrackAirspaceEquals(expected, actual);
    }

    @Test
    public void testNegativeLatLonAppendBox()
    {
        Box expected = new Box();
        double[] altitudes = {1.0,2.0};
        boolean[] terrainConformant = {true};
        DrawContextImpl dcDummy = new DrawContextImpl();

        Terrain dummyTerrain = null;
        Box.BoxGeometry geomDummy = new Box.BoxGeometry();

        List<LatLon> res = new ArrayList<LatLon>();
        expected.appendLocations(LatLon.fromDegrees(-1, -2), LatLon.fromDegrees(1, 2), LatLon.fromDegrees(4, 5),5, res);
        String stateInXml = expected.getRestorableState();

        Box actual = new Box();
        actual.restoreState(stateInXml);

        assertTrackAirspaceEquals(expected, actual);
    }

    @Test
    public void testNegativeSegmentsAppendBox()
    {
        Box expected = new Box();
        double[] altitudes = {1.0,2.0};
        boolean[] terrainConformant = {true};
        DrawContextImpl dcDummy = new DrawContextImpl();

        Terrain dummyTerrain = null;
        Box.BoxGeometry geomDummy = new Box.BoxGeometry();

        List<LatLon> res = new ArrayList<LatLon>();
        expected.appendLocations(LatLon.fromDegrees(1, 2), LatLon.fromDegrees(3, 4), LatLon.fromDegrees(4, 5),-1, res);
        String stateInXml = expected.getRestorableState();

        Box actual = new Box();
        actual.restoreState(stateInXml);

        assertTrackAirspaceEquals(expected, actual);
    }

    private static void assertTrackAirspaceEquals(Box expected, Box actual)
    {
        assertAbstractAirspaceEquals(expected, actual);
    }

    private static void assertAbstractAirspaceEquals(AbstractAirspace expected, AbstractAirspace actual)
    {
        assertEquals(expected.isVisible(), actual.isVisible());
        assertEquals(expected.getAttributes(), actual.getAttributes());
        assertEquals(expected.getHighlightAttributes(), actual.getHighlightAttributes());
        assertEquals(expected.isHighlighted(), actual.isHighlighted());
        assertEquals(expected.getAltitudes()[0], actual.getAltitudes()[0], 0.0);
        assertEquals(expected.getAltitudes()[1], actual.getAltitudes()[1], 0.0);
        assertEquals(expected.isTerrainConforming()[0], actual.isTerrainConforming()[0]);
        assertEquals(expected.isTerrainConforming()[1], actual.isTerrainConforming()[1]);
        assertEquals(expected.getAltitudeDatum()[0], actual.getAltitudeDatum()[0]);
        assertEquals(expected.getAltitudeDatum()[1], actual.getAltitudeDatum()[1]);
        assertEquals(expected.getGroundReference(), actual.getGroundReference());
        assertEquals(expected.isEnableBatchRendering(), actual.isEnableBatchRendering());
        assertEquals(expected.isEnableBatchPicking(), actual.isEnableBatchPicking());
        assertEquals(expected.isEnableDepthOffset(), actual.isEnableDepthOffset());
        assertEquals(expected.getOutlinePickWidth(), actual.getOutlinePickWidth());
        assertEquals(expected.isAlwaysOnTop(), actual.isAlwaysOnTop());
        assertEquals(expected.isDrawSurfaceShape(), actual.isDrawSurfaceShape());
        assertEquals(expected.isEnableLevelOfDetail(), actual.isEnableLevelOfDetail());
    }

    private static void assertLegEquals(Box expected, Box actual)
    {
        assertEquals(expected.getLocations()[0], actual.getLocations()[0]);
        assertEquals(expected.getLocations()[1], actual.getLocations()[1]);
        assertEquals(expected.getWidths()[0], actual.getWidths()[0], 0.0);
        assertEquals(expected.getWidths()[1], actual.getWidths()[1], 0.0);
    }
}
