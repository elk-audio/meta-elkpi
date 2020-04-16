# Specific commit and build options of raspa for Elk Pi boards
PV = "0.2.0+${SRCREV}"
SRCREV = "ee14be15ebfabf07bf287860fae609bf31f0c937"

EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=Release \
    -DBUILD_GMOCK=FALSE \
    -DINSTALL_GTEST=FALSE \
    -DRASPA_WITH_TESTS=FALSE \
    -DRASPA_WITH_APPS=OFF \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DWITH_UNIT_TESTS=FALSE \
"