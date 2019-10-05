DESCRIPTION = "A C++ library to work with the PDF file format"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=db979804f025cf55aabec7129cb671ed"
HOMEPAGE = "http://podofo.sourceforge.net"
DEPENDS = "freetype fontconfig jpeg tiff libpng openssl zlib lua"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/podofo/${BP}.tar.gz"

SRC_URI[md5sum] = "46336fc4c4ce4be814bb5fbb4d918334"
SRC_URI[sha256sum] = "e9163650955ab8e4b9532e7aa43b841bac45701f7b0f9b793a98c8ca3ef14072"

S="${WORKDIR}/${PN}-${PV}"

inherit pkgconfig cmake

PACKAGES =+ "${PN}-tools"

EXTRA_OECMAKE = "-DWANT_FONTCONFIG:BOOL=TRUE \
            -DCMAKE_INSTALL_PREFIX:PATH=/usr \
            -DCMAKE_SKIP_RPATH=ON \
            -DCMAKE_VERBOSE_MAKEFILE=ON \
            -DPODOFO_BUILD_SHARED:BOOL=TRUE \
            -DPODOFO_BUILD_STATIC:BOOL=FALSE \
            -DCMAKE_BUILD_TYPE=RELEASE \
            -DFREETYPE_INCLUDE_DIR=${STAGING_INCDIR}/freetype2 \
            -DWANT_BOOST:BOOL=0 \
"


FILES_${PN}-tools += "\
        ${bindir}/* \
"

do_compile() {
	oe_runmake
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

