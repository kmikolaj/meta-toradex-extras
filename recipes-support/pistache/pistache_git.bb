SUMMARY = "A high-performance REST Toolkit written in C++ "
HOMEPAGE = "https://github.com/oktal/pistache"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa818a259cbed7ce8bc2a22d35a464fc"
DEPENDS = "gtest"

SRC_URI = "gitsm://github.com/oktal/pistache.git;protocol=https"

SRCREV = "37a8749ccb924d188f2781eee2bcb6a93449150d"

PR = "r0"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake

BBCLASSEXTEND = "native nativesdk"

FILES_${PN} += "${libdir}/* ${includedir}"
