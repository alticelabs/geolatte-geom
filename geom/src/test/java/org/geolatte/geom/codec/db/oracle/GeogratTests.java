/*
 * Copyright (C) 2015 GEOGRAT Informationssystem GmbH, Germany All rights
 * reserved. This software is the confidential and proprietary information of
 * GEOGRAT Informationssystem GmbH (GEOGRAT). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with GEOGRAT. http://www.geograt.de
 */
package org.geolatte.geom.codec.db.oracle;

import org.geolatte.geom.jts.JTS;
import org.junit.Assert;
import org.junit.Test;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

/**
 * @author Christian Marsch
 */
public class GeogratTests {

	@Test
	public void testPlainOldPolygon() {

		SDOGeometry sdo =
				SDOGeometryHelper.sdoGeometry(3003, 0, null, new int[] { 1, 3, 1 }, new Double[] { 3569204.323,
						5943986.624, 0.0, 3569254.315, 5943987.294, 0.0, 3569255.005, 5943937.298, 0.0, 3569205.013,
						5943936.628, 0.0, 3569204.323, 5943986.624, 0.0 });

		@SuppressWarnings("unchecked")
		com.vividsolutions.jts.geom.Geometry jtsGeo = JTS.to(Decoders.decode(sdo));
		Assert.assertTrue(jtsGeo.isValid());
		Assert.assertTrue(jtsGeo instanceof Polygon);
		Assert.assertTrue(!jtsGeo.isRectangle());
	}

	@Test
	public void testRectangle() {
		SDOGeometry sdo =
				SDOGeometryHelper.sdoGeometry(3003, 0, null, new int[] { 1, 1003, 3 }, new Double[] { 3568381.725,
						5942919.687, 0.0, 3571875.563, 5944981.37752, 0.0 });

		@SuppressWarnings("unchecked")
		com.vividsolutions.jts.geom.Geometry jtsGeo = JTS.to(Decoders.decode(sdo));
		Assert.assertTrue(jtsGeo.isValid());
		Assert.assertTrue(jtsGeo instanceof Polygon);
		Assert.assertTrue(jtsGeo.isRectangle());
	}

	@Test
	public void testRectangleLine() {
		SDOGeometry sdo =
				SDOGeometryHelper.sdoGeometry(3003, 0, null, new int[] { 1, 1003, 3 }, new Double[] { 3568381.725,
						5942919.687, 0.0, 3571875.563, 5944981.37752, 0.0 });

		@SuppressWarnings("unchecked")
		com.vividsolutions.jts.geom.Geometry jtsGeo = JTS.to(Decoders.decode(sdo));
		Assert.assertTrue(jtsGeo.isValid());
		Assert.assertTrue(jtsGeo instanceof Polygon);
		Assert.assertTrue(jtsGeo.isRectangle());
	}

	@Test
	public void testArc3D() {
		SDOGeometry sdo =
				SDOGeometryHelper.sdoGeometry(3002, 0, null,
						new int[] { 1, 4, 4, 1, 2, 1, 4, 2, 2, 10, 2, 1, 13, 2, 2 }, new Double[] { 3568643.2332,
								5944170.1415, 0.0, 3568643.7754, 5944170.8294, 0.0, 3568646.6712, 5944171.1457, 0.0,
								3568649.5525, 5944171.5745, 0.0, 3568649.0651, 5944170.8232, 0.0, 3568646.1605,
								5944170.3853, 0.0, 3568643.2332, 5944170.1415, 0.0 });

		@SuppressWarnings("unchecked")
		com.vividsolutions.jts.geom.Geometry jtsGeo = JTS.to(Decoders.decode(sdo));
		Assert.assertTrue(jtsGeo.isValid());

		Assert.assertTrue(jtsGeo instanceof LineString);
		Assert.assertTrue(jtsGeo.getNumPoints() > 90);
		Assert.assertTrue(!jtsGeo.isRectangle());
	}

	@Test
	public void testArc3D3() {

		SDOGeometry sdo =
				SDOGeometryHelper.sdoGeometry(3003, 0, null, new int[] { 1, 1005, 3, 1, 2, 1, 4, 2, 2, 10, 2, 1 },
						new Double[] { 3569548.9692, 5943673.2351, 0.0, 3569546.1529, 5943673.2351, 0.0, 3569540.3401,
								5943671.8851, 0.0, 3569546.1529, 5943670.5351, 0.0, 3569548.9692, 5943670.5351, 0.0,
								3569548.9692, 5943673.2351, 0.0 });

		@SuppressWarnings("unchecked")
		com.vividsolutions.jts.geom.Geometry jtsGeo = JTS.to(Decoders.decode(sdo));
		Assert.assertTrue(jtsGeo.isValid());

		Assert.assertTrue(jtsGeo instanceof Polygon);
		Assert.assertTrue(jtsGeo.getNumPoints() > 90);
		Assert.assertTrue(!jtsGeo.isRectangle());
	}

	@Test
	public void testArc3DTest2() {
		SDOGeometry sdo =
				SDOGeometryHelper.sdoGeometry(3003, 0, null, new int[] { 1, 5, 8, 1, 2, 2, 7, 2, 1, 619, 2, 2, 625, 2,
						1, 997, 2, 2, 1003, 2, 1, 1138, 2, 2, 1144, 2, 1 }, new Double[] { 3575165.629, 5936304.714,
						0.0, 3575165.507, 5936304.913, 0.0, 3575165.317, 5936305.049, 0.0, 3575165.052, 5936305.257,
						0.0, 3575164.786, 5936305.472, 0.0, 3575164.519, 5936305.701, 0.0, 3575164.25, 5936305.95, 0.0,
						3575163.977, 5936306.227, 0.0, 3575163.702, 5936306.539, 0.0, 3575163.433, 5936306.896, 0.0,
						3575163.177, 5936307.306, 0.0, 3575162.944, 5936307.779, 0.0, 3575162.743, 5936308.326, 0.0,
						3575162.581, 5936308.947, 0.0, 3575162.455, 5936309.614, 0.0, 3575162.363, 5936310.29, 0.0,
						3575162.3, 5936310.939, 0.0, 3575162.263, 5936311.523, 0.0, 3575162.247, 5936312.014, 0.0,
						3575162.244, 5936312.417, 0.0, 3575162.245, 5936312.745, 0.0, 3575162.242, 5936313.01, 0.0,
						3575162.225, 5936313.225, 0.0, 3575162.189, 5936313.411, 0.0, 3575162.14, 5936313.613, 0.0,
						3575162.084, 5936313.884, 0.0, 3575162.029, 5936314.279, 0.0, 3575161.985, 5936314.85, 0.0,
						3575161.956, 5936315.627, 0.0, 3575161.943, 5936316.553, 0.0, 3575161.943, 5936317.544, 0.0,
						3575161.956, 5936318.52, 0.0, 3575161.977, 5936319.398, 0.0, 3575162.007, 5936320.117, 0.0,
						3575162.045, 5936320.691, 0.0, 3575162.092, 5936321.155, 0.0, 3575162.148, 5936321.543, 0.0,
						3575162.213, 5936321.891, 0.0, 3575162.289, 5936322.235, 0.0, 3575162.377, 5936322.627, 0.0,
						3575162.478, 5936323.123, 0.0, 3575162.594, 5936323.775, 0.0, 3575162.727, 5936324.639, 0.0,
						3575162.877, 5936325.744, 0.0, 3575163.041, 5936327.01, 0.0, 3575163.21, 5936328.336, 0.0,
						3575163.381, 5936329.615, 0.0, 3575163.546, 5936330.745, 0.0, 3575163.701, 5936331.648, 0.0,
						3575163.847, 5936332.347, 0.0, 3575163.986, 5936332.895, 0.0, 3575164.121, 5936333.341, 0.0,
						3575164.253, 5936333.736, 0.0, 3575170.816, 5936332.541, 0.0, 3575170.865, 5936331.919, 0.0,
						3575170.912, 5936331.311, 0.0, 3575170.955, 5936330.728, 0.0, 3575170.991, 5936330.185, 0.0,
						3575171.019, 5936329.693, 0.0, 3575171.037, 5936329.262, 0.0, 3575171.045, 5936328.881, 0.0,
						3575171.042, 5936328.535, 0.0, 3575171.029, 5936328.209, 0.0, 3575171.007, 5936327.889, 0.0,
						3575170.974, 5936327.56, 0.0, 3575170.934, 5936327.219, 0.0, 3575170.889, 5936326.861, 0.0,
						3575170.841, 5936326.483, 0.0, 3575170.791, 5936326.083, 0.0, 3575170.744, 5936325.657, 0.0,
						3575170.702, 5936325.206, 0.0, 3575170.67, 5936324.731, 0.0, 3575170.653, 5936324.235, 0.0,
						3575170.656, 5936323.718, 0.0, 3575170.68, 5936323.183, 0.0, 3575170.722, 5936322.636, 0.0,
						3575170.773, 5936322.086, 0.0, 3575170.828, 5936321.538, 0.0, 3575170.879, 5936321.001, 0.0,
						3575170.921, 5936320.481, 0.0, 3575170.954, 5936319.979, 0.0, 3575170.981, 5936319.492, 0.0,
						3575171.003, 5936319.021, 0.0, 3575171.023, 5936318.563, 0.0, 3575171.043, 5936318.117, 0.0,
						3575171.063, 5936317.679, 0.0, 3575171.085, 5936317.243, 0.0, 3575171.111, 5936316.803, 0.0,
						3575171.141, 5936316.353, 0.0, 3575171.176, 5936315.889, 0.0, 3575171.213, 5936315.407, 0.0,
						3575171.247, 5936314.902, 0.0, 3575171.273, 5936314.372, 0.0, 3575171.286, 5936313.813, 0.0,
						3575171.284, 5936313.225, 0.0, 3575171.267, 5936312.619, 0.0, 3575171.239, 5936312.014, 0.0,
						3575171.2, 5936311.423, 0.0, 3575171.155, 5936310.864, 0.0, 3575171.105, 5936310.351, 0.0,
						3575171.053, 5936309.891, 0.0, 3575171.003, 5936309.489, 0.0, 3575170.956, 5936309.15, 0.0,
						3575170.916, 5936308.88, 0.0, 3575170.883, 5936308.678, 0.0, 3575170.853, 5936308.522, 0.0,
						3575170.816, 5936308.382, 0.0, 3575170.765, 5936308.231, 0.0, 3575170.693, 5936308.04, 0.0,
						3575170.594, 5936307.789, 0.0, 3575170.478, 5936307.495, 0.0, 3575170.357, 5936307.184, 0.0,
						3575170.241, 5936306.881, 0.0, 3575170.145, 5936306.612, 0.0, 3575170.076, 5936306.395, 0.0,
						3575170.031, 5936306.226, 0.0, 3575170.004, 5936306.093, 0.0, 3575169.99, 5936305.983, 0.0,
						3575169.982, 5936305.885, 0.0, 3575171.001, 5936300.546, 0.0, 3575170.915, 5936300.517, 0.0,
						3575170.83, 5936300.481, 0.0, 3575170.744, 5936300.431, 0.0, 3575170.658, 5936300.36, 0.0,
						3575170.571, 5936300.263, 0.0, 3575170.486, 5936300.133, 0.0, 3575170.408, 5936299.978, 0.0,
						3575170.345, 5936299.807, 0.0, 3575170.306, 5936299.627, 0.0, 3575170.298, 5936299.447, 0.0,
						3575170.327, 5936299.276, 0.0, 3575170.384, 5936299.118, 0.0, 3575170.462, 5936298.978, 0.0,
						3575170.548, 5936298.858, 0.0, 3575170.633, 5936298.764, 0.0, 3575170.71, 5936298.696, 0.0,
						3575170.781, 5936298.649, 0.0, 3575170.852, 5936298.613, 0.0, 3575170.929, 5936298.579, 0.0,
						3575171.015, 5936298.539, 0.0, 3575171.118, 5936298.483, 0.0, 3575171.241, 5936298.404, 0.0,
						3575171.389, 5936298.296, 0.0, 3575171.568, 5936298.151, 0.0, 3575171.782, 5936297.961, 0.0,
						3575172.033, 5936297.723, 0.0, 3575172.315, 5936297.445, 0.0, 3575172.62, 5936297.141, 0.0,
						3575172.94, 5936296.822, 0.0, 3575173.265, 5936296.5, 0.0, 3575173.591, 5936296.185, 0.0,
						3575173.925, 5936295.875, 0.0, 3575174.277, 5936295.563, 0.0, 3575174.658, 5936295.245, 0.0,
						3575175.079, 5936294.915, 0.0, 3575175.547, 5936294.573, 0.0, 3575176.058, 5936294.236, 0.0,
						3575176.605, 5936293.928, 0.0, 3575177.181, 5936293.672, 0.0, 3575177.781, 5936293.49, 0.0,
						3575178.397, 5936293.401, 0.0, 3575179.024, 5936293.394, 0.0, 3575179.658, 5936293.456, 0.0,
						3575180.294, 5936293.57, 0.0, 3575180.928, 5936293.721, 0.0, 3575181.556, 5936293.897, 0.0,
						3575182.185, 5936294.09, 0.0, 3575182.821, 5936294.295, 0.0, 3575183.472, 5936294.505, 0.0,
						3575184.146, 5936294.715, 0.0, 3575184.846, 5936294.919, 0.0, 3575185.562, 5936295.102, 0.0,
						3575186.281, 5936295.25, 0.0, 3575186.989, 5936295.348, 0.0, 3575187.671, 5936295.382, 0.0,
						3575188.315, 5936295.34, 0.0, 3575188.915, 5936295.233, 0.0, 3575189.465, 5936295.072, 0.0,
						3575189.96, 5936294.871, 0.0, 3575190.393, 5936294.643, 0.0, 3575190.764, 5936294.401, 0.0,
						3575191.087, 5936294.157, 0.0, 3575191.38, 5936293.924, 0.0, 3575191.661, 5936293.714, 0.0,
						3575191.95, 5936293.539, 0.0, 3575192.26, 5936293.408, 0.0, 3575192.591, 5936293.316, 0.0,
						3575192.937, 5936293.252, 0.0, 3575193.293, 5936293.208, 0.0, 3575193.654, 5936293.173, 0.0,
						3575194.05, 5936293.296, 0.0, 3575194.439, 5936293.426, 0.0, 3575194.816, 5936293.569, 0.0,
						3575195.172, 5936293.734, 0.0, 3575195.502, 5936293.926, 0.0, 3575195.802, 5936294.149, 0.0,
						3575196.079, 5936294.392, 0.0, 3575196.342, 5936294.642, 0.0, 3575196.601, 5936294.885, 0.0,
						3575196.865, 5936295.107, 0.0, 3575197.142, 5936295.296, 0.0, 3575197.432, 5936295.456, 0.0,
						3575197.733, 5936295.591, 0.0, 3575198.042, 5936295.706, 0.0, 3575198.358, 5936295.806, 0.0,
						3575198.678, 5936295.897, 0.0, 3575198.95, 5936295.966, 0.0, 3575199.666, 5936295.909, 0.0,
						3575200.171, 5936295.398, 0.0, 3575200.309, 5936295.026, 0.0, 3575200.516, 5936294.638, 0.0,
						3575200.807, 5936294.252, 0.0, 3575201.194, 5936293.872, 0.0, 3575201.657, 5936293.51, 0.0,
						3575202.165, 5936293.18, 0.0, 3575202.691, 5936292.896, 0.0, 3575203.205, 5936292.672, 0.0,
						3575203.684, 5936292.518, 0.0, 3575204.13, 5936292.424, 0.0, 3575204.551, 5936292.374, 0.0,
						3575204.955, 5936292.354, 0.0, 3575205.352, 5936292.349, 0.0, 3575206.145, 5936291.409, 0.0,
						3575206.14, 5936291.256, 0.0, 3575206.131, 5936291.099, 0.0, 3575206.11, 5936290.938, 0.0,
						3575206.073, 5936290.768, 0.0, 3575206.013, 5936290.588, 0.0, 3575205.929, 5936290.395, 0.0,
						3575205.82, 5936290.192, 0.0, 3575205.691, 5936289.98, 0.0, 3575205.545, 5936289.762, 0.0,
						3575205.386, 5936289.54, 0.0, 3575205.219, 5936289.317, 0.0, 3575205.052, 5936289.093, 0.0,
						3575204.896, 5936288.867, 0.0, 3575204.761, 5936288.642, 0.0, 3575204.658, 5936288.416, 0.0,
						3575204.591, 5936288.188, 0.0, 3575204.544, 5936287.953, 0.0, 3575204.497, 5936287.701, 0.0,
						3575204.426, 5936287.425, 0.0, 3575204.312, 5936287.117, 0.0, 3575204.138, 5936286.772, 0.0,
						3575203.915, 5936286.401, 0.0, 3575203.658, 5936286.018, 0.0, 3575203.383, 5936285.639, 0.0,
						3575203.106, 5936285.277, 0.0, 3575202.842, 5936284.943, 0.0, 3575202.583, 5936284.631, 0.0,
						3575202.323, 5936284.329, 0.0, 3575202.054, 5936284.027, 0.0, 3575201.772, 5936283.715, 0.0,
						3575201.471, 5936283.384, 0.0, 3575201.153, 5936283.038, 0.0, 3575200.822, 5936282.687, 0.0,
						3575200.481, 5936282.338, 0.0, 3575200.134, 5936281.998, 0.0, 3575199.784, 5936281.674, 0.0,
						3575199.437, 5936281.368, 0.0, 3575199.099, 5936281.08, 0.0, 3575198.774, 5936280.81, 0.0,
						3575198.468, 5936280.56, 0.0, 3575198.185, 5936280.33, 0.0, 3575197.923, 5936280.123, 0.0,
						3575197.679, 5936279.944, 0.0, 3575197.449, 5936279.797, 0.0, 3575197.23, 5936279.685, 0.0,
						3575197.017, 5936279.61, 0.0, 3575196.805, 5936279.559, 0.0, 3575196.584, 5936279.517, 0.0,
						3575196.348, 5936279.467, 0.0, 3575196.09, 5936279.396, 0.0, 3575195.802, 5936279.291, 0.0,
						3575195.483, 5936279.16, 0.0, 3575195.134, 5936279.017, 0.0, 3575194.754, 5936278.875, 0.0,
						3575194.342, 5936278.745, 0.0, 3575193.901, 5936278.637, 0.0, 3575193.441, 5936278.541, 0.0,
						3575192.973, 5936278.444, 0.0, 3575192.509, 5936278.332, 0.0, 3575192.061, 5936278.191, 0.0,
						3575191.639, 5936278.014, 0.0, 3575191.244, 5936277.811, 0.0, 3575190.875, 5936277.598, 0.0,
						3575190.532, 5936277.392, 0.0, 3575190.214, 5936277.209, 0.0, 3575189.916, 5936277.06, 0.0,
						3575189.613, 5936276.931, 0.0, 3575189.277, 5936276.804, 0.0, 3575188.879, 5936276.661, 0.0,
						3575188.391, 5936276.482, 0.0, 3575187.796, 5936276.254, 0.0, 3575187.126, 5936275.983, 0.0,
						3575186.425, 5936275.681, 0.0, 3575185.735, 5936275.36, 0.0, 3575185.101, 5936275.03, 0.0,
						3575184.556, 5936274.703, 0.0, 3575184.097, 5936274.386, 0.0, 3575183.711, 5936274.086, 0.0,
						3575183.385, 5936273.809, 0.0, 3575183.105, 5936273.564, 0.0, 3575182.856, 5936273.352, 0.0,
						3575182.614, 5936273.162, 0.0, 3575182.353, 5936272.977, 0.0, 3575182.045, 5936272.782, 0.0,
						3575181.665, 5936272.56, 0.0, 3575181.196, 5936272.3, 0.0, 3575180.664, 5936272.006, 0.0,
						3575180.107, 5936271.687, 0.0, 3575179.56, 5936271.353, 0.0, 3575179.061, 5936271.013, 0.0,
						3575178.634, 5936270.674, 0.0, 3575178.26, 5936270.345, 0.0, 3575177.908, 5936270.03, 0.0,
						3575177.546, 5936269.737, 0.0, 3575177.142, 5936269.471, 0.0, 3575176.675, 5936269.236, 0.0,
						3575176.164, 5936269.027, 0.0, 3575175.635, 5936268.833, 0.0, 3575175.116, 5936268.646, 0.0,
						3575174.636, 5936268.458, 0.0, 3575174.211, 5936268.262, 0.0, 3575173.819, 5936268.06, 0.0,
						3575173.426, 5936267.858, 0.0, 3575173.001, 5936267.661, 0.0, 3575172.51, 5936267.474, 0.0,
						3575171.928, 5936267.299, 0.0, 3575171.267, 5936267.136, 0.0, 3575170.547, 5936266.982, 0.0,
						3575169.787, 5936266.834, 0.0, 3575169.309, 5936266.745, 0.0, 3575169.11, 5936266.651, 0.0,
						3575169.015, 5936266.452, 0.0, 3575169.907, 5936236.3, 0.0, 3575170.149, 5936236.275, 0.0,
						3575170.387, 5936236.234, 0.0, 3575170.614, 5936236.16, 0.0, 3575170.827, 5936236.038, 0.0,
						3575171.02, 5936235.851, 0.0, 3575171.189, 5936235.588, 0.0, 3575171.332, 5936235.254, 0.0,
						3575171.446, 5936234.861, 0.0, 3575171.528, 5936234.418, 0.0, 3575171.578, 5936233.936, 0.0,
						3575171.594, 5936233.427, 0.0, 3575171.588, 5936232.903, 0.0, 3575171.573, 5936232.376, 0.0,
						3575171.562, 5936231.86, 0.0, 3575171.567, 5936231.368, 0.0, 3575171.6, 5936230.91, 0.0,
						3575171.656, 5936230.481, 0.0, 3575171.731, 5936230.073, 0.0, 3575171.818, 5936229.681, 0.0,
						3575171.911, 5936229.296, 0.0, 3575189.068, 5936112.653, 0.0, 3575185.635, 5936112.014, 0.0,
						3575167.707, 5936231.274, 0.0, 3575167.637, 5936231.666, 0.0, 3575167.569, 5936232.063, 0.0,
						3575167.505, 5936232.47, 0.0, 3575167.448, 5936232.893, 0.0, 3575167.4, 5936233.337, 0.0,
						3575167.362, 5936233.802, 0.0, 3575167.34, 5936234.272, 0.0, 3575167.337, 5936234.726, 0.0,
						3575167.357, 5936235.141, 0.0, 3575167.405, 5936235.498, 0.0, 3575167.482, 5936235.781, 0.0,
						3575167.585, 5936235.995, 0.0, 3575167.706, 5936236.154, 0.0, 3575167.838, 5936236.27, 0.0,
						3575167.976, 5936236.354, 0.0, 3575168.113, 5936236.419, 0.0, 3575168.249, 5936236.468, 0.0,
						3575168.383, 5936236.506, 0.0, 3575168.517, 5936236.537, 0.0, 3575168.651, 5936236.564, 0.0,
						3575167.901, 5936266.098, 0.0, 3575167.665, 5936266.394, 0.0, 3575167.287, 5936266.394, 0.0,
						3575167.04, 5936266.343, 0.0, 3575166.65, 5936266.288, 0.0, 3575166.17, 5936266.249, 0.0,
						3575165.582, 5936266.23, 0.0, 3575164.891, 5936266.242, 0.0, 3575164.108, 5936266.296, 0.0,
						3575163.243, 5936266.401, 0.0, 3575162.308, 5936266.571, 0.0, 3575161.316, 5936266.808, 0.0,
						3575160.294, 5936267.089, 0.0, 3575159.268, 5936267.385, 0.0, 3575158.268, 5936267.665, 0.0,
						3575157.322, 5936267.899, 0.0, 3575156.454, 5936268.065, 0.0, 3575155.676, 5936268.171, 0.0,
						3575154.993, 5936268.231, 0.0, 3575154.413, 5936268.261, 0.0, 3575153.942, 5936268.276, 0.0,
						3575153.575, 5936268.291, 0.0, 3575153.262, 5936268.321, 0.0, 3575152.942, 5936268.38, 0.0,
						3575152.554, 5936268.482, 0.0, 3575152.034, 5936268.64, 0.0, 3575151.344, 5936268.864, 0.0,
						3575150.526, 5936269.139, 0.0, 3575149.643, 5936269.442, 0.0, 3575148.758, 5936269.754, 0.0,
						3575147.936, 5936270.053, 0.0, 3575147.226, 5936270.325, 0.0, 3575146.621, 5936270.587, 0.0,
						3575146.101, 5936270.864, 0.0, 3575145.645, 5936271.178, 0.0, 3575145.234, 5936271.554, 0.0,
						3575144.851, 5936272.008, 0.0, 3575144.507, 5936272.531, 0.0, 3575144.215, 5936273.105, 0.0,
						3575143.988, 5936273.713, 0.0, 3575143.842, 5936274.337, 0.0, 3575143.784, 5936274.96, 0.0,
						3575143.793, 5936275.567, 0.0, 3575143.842, 5936276.145, 0.0, 3575143.903, 5936276.68, 0.0,
						3575143.949, 5936277.158, 0.0, 3575143.96, 5936277.569, 0.0, 3575143.948, 5936277.922, 0.0,
						3575143.932, 5936278.229, 0.0, 3575143.93, 5936278.504, 0.0, 3575143.963, 5936278.759, 0.0,
						3575144.041, 5936279.007, 0.0, 3575144.153, 5936279.251, 0.0, 3575144.277, 5936279.493, 0.0,
						3575144.395, 5936279.736, 0.0, 3575144.487, 5936279.984, 0.0, 3575144.538, 5936280.235, 0.0,
						3575144.56, 5936280.481, 0.0, 3575144.567, 5936280.71, 0.0, 3575144.578, 5936280.913, 0.0,
						3575144.606, 5936281.077, 0.0, 3575144.666, 5936281.197, 0.0, 3575144.753, 5936281.287, 0.0,
						3575144.861, 5936281.365, 0.0, 3575144.983, 5936281.452, 0.0, 3575145.111, 5936281.565, 0.0,
						3575145.239, 5936281.719, 0.0, 3575145.37, 5936281.912, 0.0, 3575145.507, 5936282.134, 0.0,
						3575145.654, 5936282.379, 0.0, 3575145.814, 5936282.638, 0.0, 3575145.99, 5936282.905, 0.0,
						3575146.185, 5936283.178, 0.0, 3575146.404, 5936283.455, 0.0, 3575146.648, 5936283.736, 0.0,
						3575146.921, 5936284.02, 0.0, 3575147.225, 5936284.306, 0.0, 3575147.553, 5936284.591, 0.0,
						3575147.899, 5936284.872, 0.0, 3575148.254, 5936285.145, 0.0, 3575148.612, 5936285.407, 0.0,
						3575148.967, 5936285.657, 0.0, 3575149.316, 5936285.898, 0.0, 3575149.66, 5936286.135, 0.0,
						3575149.998, 5936286.373, 0.0, 3575150.33, 5936286.617, 0.0, 3575150.652, 5936286.87, 0.0,
						3575150.973, 5936287.127, 0.0, 3575151.299, 5936287.381, 0.0, 3575151.638, 5936287.625, 0.0,
						3575151.997, 5936287.851, 0.0, 3575152.381, 5936288.055, 0.0, 3575152.779, 5936288.241, 0.0,
						3575153.181, 5936288.412, 0.0, 3575153.574, 5936288.574, 0.0, 3575153.946, 5936288.732, 0.0,
						3575154.288, 5936288.89, 0.0, 3575154.604, 5936289.044, 0.0, 3575154.901, 5936289.189, 0.0,
						3575155.186, 5936289.32, 0.0, 3575155.465, 5936289.432, 0.0, 3575155.744, 5936289.522, 0.0,
						3575156.024, 5936289.597, 0.0, 3575156.304, 5936289.667, 0.0, 3575156.582, 5936289.74, 0.0,
						3575156.858, 5936289.825, 0.0, 3575157.132, 5936289.931, 0.0, 3575157.406, 5936290.059, 0.0,
						3575157.681, 5936290.208, 0.0, 3575157.962, 5936290.38, 0.0, 3575158.25, 5936290.574, 0.0,
						3575158.548, 5936290.788, 0.0, 3575158.857, 5936291.011, 0.0, 3575159.179, 5936291.226, 0.0,
						3575159.515, 5936291.421, 0.0, 3575159.867, 5936291.58, 0.0, 3575160.234, 5936291.693, 0.0,
						3575160.606, 5936291.773, 0.0, 3575160.968, 5936291.836, 0.0, 3575161.31, 5936291.898, 0.0,
						3575161.617, 5936291.976, 0.0, 3575161.88, 5936292.082, 0.0, 3575162.104, 5936292.214, 0.0,
						3575162.298, 5936292.364, 0.0, 3575162.47, 5936292.527, 0.0, 3575162.627, 5936292.696, 0.0,
						3575162.778, 5936292.866, 0.0, 3575162.924, 5936293.035, 0.0, 3575163.066, 5936293.204, 0.0,
						3575163.206, 5936293.373, 0.0, 3575163.345, 5936293.541, 0.0, 3575163.474, 5936293.719, 0.0,
						3575163.598, 5936293.894, 0.0, 3575163.715, 5936294.061, 0.0, 3575163.82, 5936294.218, 0.0,
						3575163.91, 5936294.359, 0.0, 3575163.983, 5936294.487, 0.0, 3575164.043, 5936294.618, 0.0,
						3575164.1, 5936294.775, 0.0, 3575164.161, 5936294.979, 0.0, 3575164.234, 5936295.252, 0.0,
						3575164.324, 5936295.609, 0.0, 3575164.43, 5936296.039, 0.0, 3575164.547, 5936296.525, 0.0,
						3575164.672, 5936297.049, 0.0, 3575164.801, 5936297.594, 0.0, 3575164.93, 5936298.145, 0.0,
						3575165.055, 5936298.69, 0.0, 3575165.172, 5936299.222, 0.0, 3575165.277, 5936299.734, 0.0,
						3575165.366, 5936300.217, 0.0, 3575165.436, 5936300.667, 0.0, 3575165.49, 5936301.095, 0.0,
						3575165.529, 5936301.517, 0.0, 3575165.558, 5936301.948, 0.0, 3575165.579, 5936302.404, 0.0,
						3575165.595, 5936302.896, 0.0, 3575165.608, 5936303.421, 0.0, 3575165.618, 5936303.969, 0.0,
						3575165.627, 5936304.533, 0.0, 3575165.629, 5936304.714, 0.0

				});

		@SuppressWarnings("unchecked")
		com.vividsolutions.jts.geom.Geometry jtsGeo = JTS.to(Decoders.decode(sdo));
		Assert.assertTrue(jtsGeo.isValid());

		Assert.assertTrue(jtsGeo instanceof Polygon);
		Assert.assertTrue(jtsGeo.getNumPoints() > 90);
		Assert.assertTrue(!jtsGeo.isRectangle());
	}

	@Test
	public void testPolygonWithCompounds() {

		SDOGeometry sdo =
				SDOGeometryHelper.sdoGeometry(3003, 0, null, new int[] { 1, 1005, 5, 1, 2, 1, 58, 2, 2, 64, 2, 1, 277,
						2, 2, 283, 2, 1 }, new Double[] { 3571074.1333, 5944777.273, 0.0, 3570974.1333, 5944777.2722,
						0.0, 3570972.8739, 5944916.7703, 0.0, 3570919.72, 5944895.796, 0.0, 3570874.046, 5944877.348,
						0.0, 3570841.383, 5944864.911, 0.0, 3570808.484, 5944852.416, 0.0, 3570756.171, 5944832.498,
						0.0, 3570708.503, 5944814.401, 0.0, 3570676.7598, 5944801.6349, 0.0, 3570592.873, 5944768.181,
						0.0, 3570567.346, 5944757.986, 0.0, 3570465.819, 5944716.985, 0.0, 3570391.856, 5944688.232,
						0.0, 3570279.276, 5944644.468, 0.0, 3570273.22, 5944640.06, 0.0, 3570203.16, 5944589.076, 0.0,
						3570197.97, 5944585.132, 0.0, 3570175.54, 5944567.542, 0.0, 3570155.8195, 5944592.595, 0.0,
						3570133.5111, 5944590.7443, 0.0, 3570114.644, 5944602.791, 0.0, 3570105.605, 5944604.228, 0.0,
						3570091.413, 5944606.484, 0.0, 3570080.109, 5944608.282, 0.0, 3570065.883, 5944610.544, 0.0,
						3570037.731, 5944615.02, 0.0, 3570012.064, 5944619.101, 0.0, 3569994.177, 5944622.05, 0.0,
						3569991.637, 5944622.55, 0.0, 3569967.378, 5944626.379, 0.0, 3569938.921, 5944630.996, 0.0,
						3569924.843, 5944633.194, 0.0, 3569922.573, 5944633.539, 0.0, 3569910.955, 5944634.972, 0.0,
						3569904.258, 5944635.833, 0.0, 3569897.147, 5944636.661, 0.0, 3569890.355, 5944637.317, 0.0,
						3569882.061, 5944637.351, 0.0, 3569878.681, 5944637.3, 0.0, 3569866.17, 5944637.69, 0.0,
						3569850.775, 5944638.286, 0.0, 3569837.1453, 5944638.6207, 0.0, 3569837.8796, 5944585.9419,
						0.0, 3569836.75, 5944585.927, 0.0, 3569838.0037, 5944524.4718, 0.0, 3569840.875, 5944524.289,
						0.0, 3569844.875, 5944523.43, 0.0, 3569848.437, 5944522.148, 0.0, 3569852.125, 5944520.379,
						0.0, 3569855.125, 5944518.375, 0.0, 3569857.875, 5944515.617, 0.0, 3569860.375, 5944512.434,
						0.0, 3569862.437, 5944508.766, 0.0, 3569863.812, 5944505.195, 0.0, 3569864.625, 5944501.992,
						0.0, 3569865.312, 5944498.445, 0.0, 3569865.312, 5944495.562, 0.0, 3569865.062, 5944493.062,
						0.0, 3569864.375, 5944489.773, 0.0, 3569863.687, 5944487.414, 0.0, 3569861.875, 5944483.273,
						0.0, 3569858.812, 5944479.234, 0.0, 3569856.375, 5944476.469, 0.0, 3569853.187, 5944473.727,
						0.0, 3569849.937, 5944470.117, 0.0, 3569848.125, 5944467.758, 0.0, 3569846.75, 5944464.02, 0.0,
						3569846.312, 5944461.32, 0.0, 3569846.375, 5944457.039, 0.0, 3569847.125, 5944452.039, 0.0,
						3569847.81, 5944448.383, 0.0, 3569849.48, 5944438.243, 0.0, 3569850.125, 5944435.09, 0.0,
						3569850.75, 5944430.012, 0.0, 3569851.687, 5944423.512, 0.0, 3569852.562, 5944417.711, 0.0,
						3569853.5, 5944409.863, 0.0, 3569854.125, 5944404.645, 0.0, 3569855.0, 5944396.785, 0.0,
						3569855.562, 5944390.566, 0.0, 3569856.25, 5944383.746, 0.0, 3569856.812, 5944377.816, 0.0,
						3569857.562, 5944370.09, 0.0, 3569858.312, 5944362.16, 0.0, 3569862.6863, 5944274.1013, 0.0,
						3569857.8543, 5944208.6593, 0.0, 3569855.1931, 5944188.0767, 0.0, 3569852.312, 5944163.504,
						0.0, 3569858.5, 5944158.246, 0.0, 3569860.875, 5944154.129, 0.0, 3569862.0893, 5944149.8143,
						0.0, 3570166.6635, 5944153.3494, 0.0, 3570181.6771, 5944162.8413, 0.0, 3570197.3351,
						5944171.228, 0.0, 3570205.0812, 5944174.6613, 0.0, 3570213.9562, 5944178.3253, 0.0,
						3570222.6442, 5944181.9543, 0.0, 3570231.8942, 5944185.2553, 0.0, 3570241.8312, 5944188.9073,
						0.0, 3570252.0192, 5944192.3573, 0.0, 3570261.2692, 5944195.2283, 0.0, 3570271.0812,
						5944198.0873, 0.0, 3570281.2062, 5944200.8373, 0.0, 3570291.7062, 5944203.2393, 0.0,
						3570302.29, 5944205.62, 0.0, 3570329.827, 5944211.5837, 0.0, 3570345.7217, 5944213.8918, 0.0,
						3570362.4315, 5944215.6568, 0.0, 3570375.8697, 5944216.2529, 0.0, 3570376.349, 5944216.195,
						0.0, 3570499.145, 5944217.548, 0.0, 3570611.89, 5944218.648, 0.0, 3570615.562, 5944219.082,
						0.0, 3570618.312, 5944219.703, 0.0, 3570621.5, 5944220.812, 0.0, 3570625.312, 5944221.992, 0.0,
						3570627.5672, 5944222.6432, 0.0, 3570627.937, 5944222.75, 0.0, 3570630.312, 5944223.793, 0.0,
						3570632.5, 5944224.402, 0.0, 3570635.312, 5944224.73, 0.0, 3570639.187, 5944224.949, 0.0,
						3570698.8759, 5944225.3967, 0.0, 3571071.753, 5944228.978, 0.0, 3571080.9214, 5944229.4014,
						0.0, 3571079.694, 5944354.834, 0.0, 3571078.1459, 5944513.0485, 0.0, 3571076.9501,
						5944513.0186, 0.0, 3571075.555, 5944642.429, 0.0, 3571074.792, 5944713.209, 0.0, 3571074.225,
						5944765.8, 0.0, 3571074.1333, 5944777.273, 0.0 });

		@SuppressWarnings("unchecked")
		com.vividsolutions.jts.geom.Geometry jtsGeo = JTS.to(Decoders.decode(sdo));
		Assert.assertTrue(jtsGeo.isValid());
		Assert.assertTrue(jtsGeo instanceof Polygon);
		Assert.assertTrue(!jtsGeo.isRectangle());
	}

	@Test
	public void testPlainOldPolygon2() {

		SDOGeometry sdo =
				SDOGeometryHelper.sdoGeometry(3003, 0, null, new int[] { 1, 3, 1 }, new Double[] { 3568981.365,
						5944402.176, 0.0, 3568982.069, 5944405.91, 0.0, 3568998.852, 5944405.523, 0.0, 3568999.35,
						5944369.026, 0.0, 3569013.018, 5944369.213, 0.0, 3569013.062, 5944369.285, 0.0, 3569015.5,
						5944372.512, 0.0, 3569018.562, 5944375.227, 0.0, 3569022.062, 5944377.117, 0.0, 3569025.937,
						5944378.184, 0.0, 3569029.875, 5944378.77, 0.0, 3569034.625, 5944378.504, 0.0, 3569038.875,
						5944377.301, 0.0, 3569042.25, 5944375.598, 0.0, 3569045.625, 5944373.234, 0.0, 3569047.75,
						5944371.043, 0.0, 3569048.768, 5944369.701, 0.0, 3569049.312, 5944368.984, 0.0, 3569051.312,
						5944367.25, 0.0, 3569055.312, 5944365.59, 0.0, 3569059.75, 5944365.098, 0.0, 3569064.312,
						5944365.164, 0.0, 3569069.187, 5944365.434, 0.0, 3569075.187, 5944366.016, 0.0, 3569079.75,
						5944366.594, 0.0, 3569083.856, 5944367.305, 0.0, 3569086.154, 5944367.707, 0.0, 3569086.569,
						5944367.795, 0.0, 3569086.94, 5944365.556, 0.0, 3569087.726, 5944360.811, 0.0, 3569088.584,
						5944353.474, 0.0, 3569089.979, 5944341.537, 0.0, 3569090.578, 5944334.495, 0.0, 3569091.078,
						5944328.374, 0.0, 3569091.515, 5944321.819, 0.0, 3569091.765, 5944315.624, 0.0, 3569091.765,
						5944311.647, 0.0, 3569091.515, 5944306.198, 0.0, 3569091.015, 5944301.311, 0.0, 3569089.89,
						5944295.464, 0.0, 3569087.848, 5944284.056, 0.0, 3569087.443, 5944282.181, 0.0, 3569086.952,
						5944280.664, 0.0, 3569085.765, 5944278.132, 0.0, 3569082.936, 5944274.425, 0.0, 3569079.328,
						5944270.889, 0.0, 3569076.175, 5944267.384, 0.0, 3569073.1, 5944264.055, 0.0, 3569068.151,
						5944258.859, 0.0, 3569067.437, 5944258.969, 0.0, 3569065.125, 5944259.711, 0.0, 3569064.125,
						5944260.488, 0.0, 3569063.437, 5944261.492, 0.0, 3569061.437, 5944264.195, 0.0, 3569059.5,
						5944266.336, 0.0, 3569056.312, 5944269.383, 0.0, 3569053.0, 5944271.875, 0.0, 3569049.625,
						5944273.93, 0.0, 3569046.062, 5944275.66, 0.0, 3569041.5, 5944277.199, 0.0, 3569037.125,
						5944278.07, 0.0, 3569031.937, 5944278.371, 0.0, 3569027.875, 5944278.145, 0.0, 3569023.187,
						5944277.187, 0.0, 3569019.5, 5944275.883, 0.0, 3569015.125, 5944273.828, 0.0, 3569011.875,
						5944271.883, 0.0, 3569010.062, 5944270.555, 0.0, 3569008.437, 5944269.582, 0.0, 3569006.125,
						5944269.281, 0.0, 3569003.375, 5944270.238, 0.0, 3569001.117, 5944271.72, 0.0, 3568978.752,
						5944284.723, 0.0, 3568949.646, 5944302.297, 0.0, 3568911.647, 5944325.248, 0.0, 3568907.437,
						5944328.187, 0.0, 3568902.875, 5944331.23, 0.0, 3568896.562, 5944335.016, 0.0, 3568891.875,
						5944337.73, 0.0, 3568885.75, 5944340.934, 0.0, 3568879.937, 5944343.879, 0.0, 3568874.625,
						5944346.289, 0.0, 3568867.375, 5944349.57, 0.0, 3568860.062, 5944352.5, 0.0, 3568852.5,
						5944355.426, 0.0, 3568846.25, 5944357.687, 0.0, 3568837.5, 5944360.289, 0.0, 3568828.562,
						5944362.457, 0.0, 3568822.437, 5944363.574, 0.0, 3568816.687, 5944364.434, 0.0, 3568808.875,
						5944365.527, 0.0, 3568801.187, 5944366.395, 0.0, 3568791.25, 5944367.27, 0.0, 3568786.625,
						5944367.437, 0.0, 3568781.437, 5944367.609, 0.0, 3568777.562, 5944367.777, 0.0, 3568749.006,
						5944367.361, 0.0, 3568737.049, 5944367.187, 0.0, 3568725.56, 5944366.007, 0.0, 3568715.375,
						5944365.0, 0.0, 3568708.125, 5944364.289, 0.0, 3568699.5, 5944363.199, 0.0, 3568691.75,
						5944362.312, 0.0, 3568683.937, 5944361.117, 0.0, 3568675.062, 5944359.879, 0.0, 3568668.687,
						5944358.934, 0.0, 3568663.937, 5944358.211, 0.0, 3568657.25, 5944357.168, 0.0, 3568651.187,
						5944356.223, 0.0, 3568642.25, 5944354.598, 0.0, 3568635.312, 5944353.324, 0.0, 3568628.312,
						5944352.152, 0.0, 3568621.375, 5944350.93, 0.0, 3568614.75, 5944349.605, 0.0, 3568608.562,
						5944348.301, 0.0, 3568601.062, 5944346.75, 0.0, 3568594.062, 5944345.348, 0.0, 3568585.937,
						5944343.645, 0.0, 3568578.625, 5944341.937, 0.0, 3568568.875, 5944339.629, 0.0, 3568561.5,
						5944337.797, 0.0, 3568551.375, 5944334.926, 0.0, 3568546.5, 5944333.492, 0.0, 3568541.375,
						5944332.133, 0.0, 3568537.5, 5944331.332, 0.0, 3568531.875, 5944330.687, 0.0, 3568527.687,
						5944330.855, 0.0, 3568524.687, 5944331.5, 0.0, 3568521.949, 5944332.685, 0.0, 3568520.937,
						5944333.348, 0.0, 3568519.0, 5944334.605, 0.0, 3568516.062, 5944336.246, 0.0, 3568513.5,
						5944337.449, 0.0, 3568510.687, 5944338.328, 0.0, 3568508.125, 5944338.742, 0.0, 3568505.437,
						5944338.852, 0.0, 3568502.625, 5944338.582, 0.0, 3568500.0, 5944337.778, 0.0, 3568499.046,
						5944337.314, 0.0, 3568498.236, 5944336.901, 0.0, 3568497.551, 5944336.533, 0.0, 3568496.973,
						5944336.203, 0.0, 3568496.484, 5944335.903, 0.0, 3568496.065, 5944335.627, 0.0, 3568495.698,
						5944335.367, 0.0, 3568495.364, 5944335.116, 0.0, 3568495.05, 5944334.868, 0.0, 3568494.748,
						5944334.621, 0.0, 3568494.458, 5944334.372, 0.0, 3568494.355, 5944334.279, 0.0, 3568481.125,
						5944346.622, 0.0, 3568470.439, 5944356.591, 0.0, 3568474.384, 5944368.347, 0.0, 3568563.937,
						5944376.895, 0.0, 3568571.437, 5944377.379, 0.0, 3568576.625, 5944377.613, 0.0, 3568582.25,
						5944378.184, 0.0, 3568587.687, 5944378.926, 0.0, 3568591.687, 5944379.574, 0.0, 3568598.625,
						5944380.852, 0.0, 3568604.187, 5944381.926, 0.0, 3568609.687, 5944382.75, 0.0, 3568616.312,
						5944383.492, 0.0, 3568623.25, 5944384.203, 0.0, 3568629.0, 5944384.645, 0.0, 3568635.437,
						5944384.852, 0.0, 3568641.187, 5944384.777, 0.0, 3568646.687, 5944384.734, 0.0, 3568652.125,
						5944384.895, 0.0, 3568656.937, 5944385.184, 0.0, 3568661.062, 5944385.574, 0.0, 3568665.437,
						5944386.172, 0.0, 3568669.5, 5944386.82, 0.0, 3568674.375, 5944387.617, 0.0, 3568678.875,
						5944388.262, 0.0, 3568683.687, 5944388.805, 0.0, 3568689.062, 5944389.32, 0.0, 3568693.437,
						5944389.789, 0.0, 3568697.25, 5944390.082, 0.0, 3568701.875, 5944390.422, 0.0, 3568706.75,
						5944390.863, 0.0, 3568709.5, 5944390.98, 0.0, 3568713.937, 5944391.094, 0.0, 3568718.937,
						5944391.457, 0.0, 3568723.812, 5944392.051, 0.0, 3568728.062, 5944392.621, 0.0, 3568732.625,
						5944393.344, 0.0, 3568737.875, 5944394.52, 0.0, 3568757.103, 5944399.111, 0.0, 3568758.059,
						5944407.388, 0.0, 3568772.437, 5944409.09, 0.0, 3568775.125, 5944409.562, 0.0, 3568779.812,
						5944410.055, 0.0, 3568786.125, 5944410.488, 0.0, 3568792.75, 5944410.746, 0.0, 3568798.0,
						5944410.754, 0.0, 3568803.562, 5944410.684, 0.0, 3568809.25, 5944410.535, 0.0, 3568814.687,
						5944410.184, 0.0, 3568817.5, 5944410.07, 0.0, 3568821.812, 5944410.211, 0.0, 3568826.812,
						5944410.371, 0.0, 3568832.875, 5944410.855, 0.0, 3568837.75, 5944411.426, 0.0, 3568843.125,
						5944412.348, 0.0, 3568847.625, 5944413.199, 0.0, 3568850.75, 5944413.746, 0.0, 3568853.812,
						5944414.117, 0.0, 3568856.812, 5944414.336, 0.0, 3568859.5, 5944414.324, 0.0, 3568862.187,
						5944413.781, 0.0, 3568864.875, 5944412.832, 0.0, 3568866.421, 5944412.063, 0.0, 3568867.971,
						5944411.269, 0.0, 3568878.968, 5944417.124, 0.0, 3568884.226, 5944414.671, 0.0, 3568884.417,
						5944414.754, 0.0, 3568884.738, 5944414.877, 0.0, 3568885.066, 5944414.98, 0.0, 3568885.399,
						5944415.064, 0.0, 3568885.737, 5944415.129, 0.0, 3568886.078, 5944415.174, 0.0, 3568886.421,
						5944415.199, 0.0, 3568886.765, 5944415.205, 0.0, 3568887.109, 5944415.19, 0.0, 3568887.451,
						5944415.155, 0.0, 3568887.79, 5944415.1, 0.0, 3568888.126, 5944415.026, 0.0, 3568888.457,
						5944414.932, 0.0, 3568888.782, 5944414.82, 0.0, 3568889.1, 5944414.688, 0.0, 3568889.41,
						5944414.539, 0.0, 3568889.849, 5944414.305, 0.0, 3568890.503, 5944413.94, 0.0, 3568891.146,
						5944413.557, 0.0, 3568891.779, 5944413.157, 0.0, 3568892.402, 5944412.741, 0.0, 3568893.012,
						5944412.308, 0.0, 3568893.611, 5944411.859, 0.0, 3568894.198, 5944411.394, 0.0, 3568894.772,
						5944410.913, 0.0, 3568895.127, 5944410.612, 0.0, 3568895.494, 5944410.326, 0.0, 3568895.874,
						5944410.057, 0.0, 3568896.264, 5944409.804, 0.0, 3568896.665, 5944409.568, 0.0, 3568897.076,
						5944409.349, 0.0, 3568897.495, 5944409.148, 0.0, 3568897.923, 5944408.966, 0.0, 3568898.359,
						5944408.802, 0.0, 3568898.8, 5944408.657, 0.0, 3568899.715, 5944408.389, 0.0, 3568900.636,
						5944408.14, 0.0, 3568901.562, 5944407.91, 0.0, 3568902.492, 5944407.699, 0.0, 3568903.427,
						5944407.509, 0.0, 3568904.366, 5944407.337, 0.0, 3568905.308, 5944407.186, 0.0, 3568906.252,
						5944407.054, 0.0, 3568907.107, 5944406.953, 0.0, 3568908.451, 5944406.815, 0.0, 3568909.798,
						5944406.698, 0.0, 3568911.146, 5944406.601, 0.0, 3568912.495, 5944406.523, 0.0, 3568913.845,
						5944406.466, 0.0, 3568915.196, 5944406.429, 0.0, 3568916.547, 5944406.411, 0.0, 3568917.899,
						5944406.414, 0.0, 3568919.109, 5944406.433, 0.0, 3568919.881, 5944406.461, 0.0, 3568920.651,
						5944406.508, 0.0, 3568921.421, 5944406.575, 0.0, 3568922.188, 5944406.663, 0.0, 3568922.953,
						5944406.77, 0.0, 3568923.715, 5944406.897, 0.0, 3568924.473, 5944407.043, 0.0, 3568925.227,
						5944407.209, 0.0, 3568925.977, 5944407.395, 0.0, 3568926.721, 5944407.6, 0.0, 3568927.46,
						5944407.824, 0.0, 3568928.193, 5944408.067, 0.0, 3568928.919, 5944408.329, 0.0, 3568929.639,
						5944408.61, 0.0, 3568930.266, 5944408.873, 0.0, 3568930.31, 5944408.892, 0.0, 3568930.699,
						5944409.047, 0.0, 3568931.096, 5944409.183, 0.0, 3568931.499, 5944409.3, 0.0, 3568931.907,
						5944409.398, 0.0, 3568932.319, 5944409.477, 0.0, 3568932.734, 5944409.535, 0.0, 3568933.152,
						5944409.574, 0.0, 3568933.571, 5944409.593, 0.0, 3568933.991, 5944409.592, 0.0, 3568934.41,
						5944409.571, 0.0, 3568934.827, 5944409.53, 0.0, 3568935.242, 5944409.469, 0.0, 3568935.654,
						5944409.388, 0.0, 3568936.061, 5944409.288, 0.0, 3568936.463, 5944409.169, 0.0, 3568936.711,
						5944409.088, 0.0, 3568937.755, 5944408.735, 0.0, 3568938.793, 5944408.363, 0.0, 3568939.823,
						5944407.973, 0.0, 3568940.486, 5944407.714, 0.0, 3568943.286, 5944406.608, 0.0, 3568946.078,
						5944405.483, 0.0, 3568948.863, 5944404.34, 0.0, 3568949.784, 5944403.955, 0.0, 3568951.33,
						5944403.291, 0.0, 3568952.867, 5944402.608, 0.0, 3568954.396, 5944401.908, 0.0, 3568956.265,
						5944401.049, 0.0, 3568958.143, 5944400.208, 0.0, 3568960.029, 5944399.386, 0.0, 3568961.152,
						5944398.906, 0.0, 3568961.654, 5944398.704, 0.0, 3568962.163, 5944398.521, 0.0, 3568962.679,
						5944398.357, 0.0, 3568963.2, 5944398.212, 0.0, 3568963.726, 5944398.087, 0.0, 3568964.257,
						5944397.981, 0.0, 3568964.791, 5944397.894, 0.0, 3568965.328, 5944397.828, 0.0, 3568965.866,
						5944397.781, 0.0, 3568966.407, 5944397.755, 0.0, 3568966.948, 5944397.748, 0.0, 3568967.488,
						5944397.761, 0.0, 3568968.028, 5944397.794, 0.0, 3568968.567, 5944397.848, 0.0, 3568969.103,
						5944397.921, 0.0, 3568969.196, 5944397.935, 0.0, 3568970.043, 5944398.083, 0.0, 3568970.888,
						5944398.25, 0.0, 3568971.728, 5944398.436, 0.0, 3568972.563, 5944398.642, 0.0, 3568973.394,
						5944398.867, 0.0, 3568974.219, 5944399.112, 0.0, 3568975.038, 5944399.376, 0.0, 3568975.85,
						5944399.658, 0.0, 3568976.656, 5944399.96, 0.0, 3568977.455, 5944400.28, 0.0, 3568978.246,
						5944400.619, 0.0, 3568979.029, 5944400.976, 0.0, 3568979.804, 5944401.351, 0.0, 3568980.569,
						5944401.744, 0.0, 3568981.326, 5944402.154, 0.0, 3568981.365, 5944402.176, 0.0 });

		@SuppressWarnings("unchecked")
		com.vividsolutions.jts.geom.Geometry jtsGeo = JTS.to(Decoders.decode(sdo));
		Assert.assertTrue(jtsGeo.isValid());
		Assert.assertTrue(jtsGeo instanceof Polygon);
		Assert.assertTrue(!jtsGeo.isRectangle());
	}

	@Test
	public void testPointWithNullZ() {

		SDOGeometry sdo =
				SDOGeometryHelper.sdoGeometry(3001, 0, new SDOPoint(33376662.068, 6019344.242, null), null, null);

		@SuppressWarnings("unchecked")
		com.vividsolutions.jts.geom.Geometry jtsGeo = JTS.to(Decoders.decode(sdo));
		Assert.assertTrue(jtsGeo.isValid());
		Assert.assertTrue(jtsGeo instanceof Point);
	}
}
