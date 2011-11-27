/*
 * This file is part of the GeoLatte project.
 *
 *     GeoLatte is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     GeoLatte is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with GeoLatte.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2010 - 2011 and Ownership of code is shared by:
 * Qmino bvba - Romeinsestraat 18 - 3001 Heverlee  (http://www.qmino.com)
 * Geovise bvba - Generaal Eisenhowerlei 9 - 2140 Antwerpen (http://www.geovise.com)
 */

package org.geolatte.geom;

import com.vividsolutions.jts.algorithm.ConvexHull;
import com.vividsolutions.jts.operation.BoundaryOp;
import com.vividsolutions.jts.operation.IsSimpleOp;
import com.vividsolutions.jts.operation.buffer.BufferOp;
import com.vividsolutions.jts.operation.distance.DistanceOp;
import com.vividsolutions.jts.operation.relate.RelateOp;
import org.geolatte.geom.codec.ByteBuffer;
import org.geolatte.geom.crs.CrsId;
import org.geolatte.geom.jts.JTS;

/**
 * @author Karel Maesen, Geovise BVBA
 *         creation-date: 5/3/11
 */
class JTSGeometryOperations implements GeometryOperations {

    private static boolean envelopeIntersect(Geometry geometry1, Geometry geometry2) {
        return(geometry1.getEnvelope().intersects(geometry2.getEnvelope()));
    }

    @Override
    public GeometryOperation<Boolean> createIsSimpleOp(final Geometry geometry) {
        final IsSimpleOp isSimpleOp = new IsSimpleOp(JTS.to(geometry));
        return new GeometryOperation<Boolean>(){
            @Override
            public Boolean execute() {
                return isSimpleOp.isSimple();
            }
        };
    }

    @Override
    public GeometryOperation<Geometry> createBoundaryOp(final Geometry geometry) {
        final BoundaryOp boundaryOp = new BoundaryOp(JTS.to(geometry));
        final CrsId crsId = geometry.getCrsId();
        return new GeometryOperation<Geometry>(){
            @Override
            public Geometry execute() {
                return JTS.from(boundaryOp.getBoundary(), crsId);
            }
        };
    }

    @Override
    public GeometryOperation<Envelope> createEnvelopeOp(final Geometry geometry) {
        return new GeometryOperation<Envelope> (){

            @Override
            public Envelope execute() {
                PointSequence ps = geometry.getPoints();
                EnvelopeVisitor visitor = new EnvelopeVisitor(geometry.getCrsId());
                ps.accept(visitor);
                return visitor.result();
            }
        };
    }

    @Override
    public GeometryOperation<Boolean> createIntersectsOp(final Geometry geometry, final Geometry other) {
        return new GeometryOperation<Boolean>() {
            @Override
            public Boolean execute() {
                if (!envelopeIntersect(geometry, other)) return Boolean.FALSE;
                RelateOp relateOp = new RelateOp(JTS.to(geometry), JTS.to(other));
                return relateOp.getIntersectionMatrix().isIntersects();
            }
        };
    }

    @Override
    public GeometryOperation<Boolean> createTouchesOp(final Geometry geometry, final Geometry other) {
        return new GeometryOperation<Boolean>() {
            @Override
            public Boolean execute() {
                if (!envelopeIntersect(geometry, other)) return Boolean.FALSE;
                final RelateOp relateOp = new RelateOp(JTS.to(geometry), JTS.to(other));
                return relateOp.getIntersectionMatrix().isTouches(geometry.getDimension(), other.getDimension());
            }
        };
    }

    @Override
    public GeometryOperation<Boolean> createCrossesOp(final Geometry geometry, final Geometry other) {
        return new GeometryOperation<Boolean>() {
            @Override
            public Boolean execute() {
                if (!envelopeIntersect(geometry, other)) return Boolean.FALSE;
                final RelateOp relateOp = new RelateOp(JTS.to(geometry), JTS.to(other));
                return relateOp.getIntersectionMatrix().isCrosses(geometry.getDimension(), other.getDimension());
            }
        };
    }

    @Override
    public GeometryOperation<Boolean> createContainsOp(final Geometry geometry, final Geometry other) {
        return new GeometryOperation<Boolean>() {
                    @Override
                    public Boolean execute() {
                        if (!geometry.getEnvelope().contains(other.getEnvelope())) return Boolean.FALSE;
                        final RelateOp relateOp = new RelateOp(JTS.to(geometry), JTS.to(other));
                        return relateOp.getIntersectionMatrix().isContains();
                    }
                };
    }

    @Override
    public GeometryOperation<Boolean> createOverlapsOp(final Geometry geometry, final Geometry other) {
        return new GeometryOperation<Boolean>() {
            @Override
            public Boolean execute() {
                if (!envelopeIntersect(geometry, other)) return Boolean.FALSE;
                final RelateOp relateOp = new RelateOp(JTS.to(geometry), JTS.to(other));
                return relateOp.getIntersectionMatrix().isOverlaps(geometry.getDimension(), other.getDimension());
            }
        };
    }

    @Override
    public GeometryOperation<Boolean> createRelateOp(final Geometry geometry, final Geometry other, final String matrix) {
        return new GeometryOperation<Boolean>() {
            @Override
            public Boolean execute() {
                final RelateOp relateOp = new RelateOp(JTS.to(geometry), JTS.to(other));
                return relateOp.getIntersectionMatrix().matches(matrix);
            }
        };
    }

    @Override
    public GeometryOperation<Geometry> createLocateAlongOp(Geometry geometry, double mValue) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GeometryOperation<Geometry> createLocateBetween(Geometry geometry, double mStart, double mEnd) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GeometryOperation<Double> createDistanceOp(final Geometry geometry, final Geometry other) {
        return new GeometryOperation<Double>(){
            @Override
            public Double execute() {
                final DistanceOp op =  new DistanceOp(JTS.to(geometry), JTS.to(other));
                return op.distance();
            }
        };
    }

    @Override
    public GeometryOperation<Geometry> createBufferOp(final Geometry geometry, final double distance) {
        return new GeometryOperation<Geometry>() {
            @Override
            public Geometry execute() {
                final BufferOp op = new BufferOp(JTS.to(geometry));
                return JTS.from(op.getResultGeometry(distance), geometry.getCrsId());
            }
        };
    }

    @Override
    public GeometryOperation<Geometry> createConvexHullOp(final Geometry geometry) {
        return new GeometryOperation<Geometry>(){
            @Override
            public Geometry execute() {
                final ConvexHull convexHull = new ConvexHull(JTS.to(geometry));
                return JTS.from(convexHull.getConvexHull(), geometry.getCrsId());
            }
        };
    }

    @Override
    public GeometryOperation<Geometry> createIntersectionOp(Geometry geometry, Geometry other) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GeometryOperation<Geometry> createUnionOp(Geometry geometry, Geometry other) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GeometryOperation<Geometry> createDifferenceOp(Geometry geometry, Geometry other) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GeometryOperation<Geometry> createSymDifferenceOp(Geometry geometry, Geometry other) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GeometryOperation<String> createToWKTOp(Geometry geometry) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GeometryOperation<ByteBuffer> createToWKBOp(Geometry geometry) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    private static class EnvelopeVisitor implements PointVisitor {

        double xMin,yMin, xMax,yMax;
        CrsId crsId;

        EnvelopeVisitor(CrsId crsId){
            this.crsId = crsId;
        }


        @Override
        public void visit(double[] coordinates) {
            xMin = Math.min(xMin, coordinates[0]);
            xMax = Math.max(xMax, coordinates[0]);
            yMin = Math.min(yMin, coordinates[1]);
            yMax = Math.max(yMax, coordinates[1]);
        }

        public Envelope result() {
            return new Envelope(xMin, yMin, xMax, yMax, crsId);
        }
    }


}
