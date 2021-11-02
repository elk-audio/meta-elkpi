# Specific commit and build options of raspa for Elk Pi boards
SRC_URI = "gitsm://git@bitbucket.org/mindswteam/raspalib-elk.git;protocol=ssh;nobranch=1"
PV = "0.1.4+${SRCREV}"
SRCREV = "a813661300a5a3876c7e550ae1e2613fca6e0d7f"

EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=Release \
    -DBUILD_GMOCK=FALSE \
    -DINSTALL_GTEST=FALSE \
    -DRASPA_WITH_TESTS=FALSE \
    -DRASPA_WITH_APPS=OFF \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DWITH_UNIT_TESTS=FALSE \
"

