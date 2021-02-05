# Specific commit and build options of raspa for Elk Pi boards
PV = "0.1.2+${SRCREV}"
SRCREV = "505e53582d97922a5571f0f8da74a85aaef1e683"

EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=Release \
    -DBUILD_GMOCK=FALSE \
    -DINSTALL_GTEST=FALSE \
    -DRASPA_WITH_TESTS=FALSE \
    -DRASPA_WITH_APPS=OFF \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DWITH_UNIT_TESTS=FALSE \
"
