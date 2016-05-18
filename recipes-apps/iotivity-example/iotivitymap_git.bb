SUMMARY = "Iotivity Map with GPS Server"
DESCRIPTION = "Minimalist Iotivity Client/Server application that share a postion"
HOMEPAGE = "https://github.com/TizenTeam/iotivitymap"
SECTION = "apps"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCREV = "master"
SRC_URI = "git://github.com/TizenTeam/iotivitymap.git/;protocol=http;nobranch=1"

S = "${WORKDIR}/git"

LOCAL_OPT_DIR = "/opt"
LOCAL_OPT_DIR_D = "${D}${LOCAL_OPT_DIR}"

DEPENDS += "iotivity "

DEPENDS_${PN} += "iotivity-resource-dev iotivity-resource-thin-staticdev iotivity-service-dev iotivity-service-staticdev"

BBCLASSEXTEND = "native nativesdk"
RDEPENDS_${PN} += " iotivity-resource "

EXTRA_OEMAKE = " "

do_configure() {
}

do_compile() {
 cd ${S}
 LANG=C
 export LANG
 unset DISPLAY
 LD_AS_NEEDED=1; export LD_AS_NEEDED ;
 
 oe_runmake all
}

do_install() {
 export RPM_BUILD_ROOT=${D}
 cd ${S}
 LANG=C
 export LANG
 unset DISPLAY
 rm -rf ${D}
 install -d ${D}
 oe_runmake \
  install \
  DESTDIR=${LOCAL_OPT_DIR_D} \
  #eol
}

FILES_${PN} += "${LOCAL_OPT_DIR}/${PN}/*"
FILES_${PN}-dbg += "${LOCAL_OPT_DIR}/${PN}/.debug"
