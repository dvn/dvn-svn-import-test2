installer:	dvninstall.zip
	@touch $@

DVN_WAR_FILE=dvninstall/appdeploy/dist/DVN-web.war

DVN_CONFIG_FILES=dvninstall/config/error.xsl dvninstall/config/fgdc2ddi.xsl dvninstall/config/graphml.props dvninstall/config/header.xsl dvninstall/config/jhove.conf dvninstall/config/logging.properties dvninstall/config/metadata.xsl dvninstall/config/mif2ddi.xsl dvninstall/config/neodb.props dvninstall/config/oai_dc2ddi.xsl dvninstall/config/oaicat.properties dvninstall/web-core.jar dvninstall/robots.txt

DVN_SQL_FILE_TEMPLATE=dvninstall/referenceData.sql.TEMPLATE
DVN_SQL_FILE_SOURCE=../../src/DVN-EJB/src/conf/referenceData.sql

DVN_NETWORKDATA_LIBS=dvninstall/config/networkData/lib/collections-generic-4.01.jar dvninstall/config/networkData/lib/colt-1.2.0.jar dvninstall/config/networkData/lib/concurrent-1.3.4.jar dvninstall/config/networkData/lib/geronimo-jta_1.1_spec-1.1.1.jar dvninstall/config/networkData/lib/jung-algorithms-2.0.jar dvninstall/config/networkData/lib/jung-api-2.0.jar dvninstall/config/networkData/lib/jung-visualization-2.0.jar dvninstall/config/networkData/lib/junit-3.8.1.jar dvninstall/config/networkData/lib/lucene-core-2.9.2.jar dvninstall/config/networkData/lib/neo4j-index-1.1.jar dvninstall/config/networkData/lib/neo4j-kernel-1.1.jar dvninstall/config/networkData/lib/neo4j-utils-1.1.jar dvninstall/config/networkData/lib/nestedvm-1.0.jar dvninstall/config/networkData/lib/network_utils-1.0-SNAPSHOT.jar dvninstall/config/networkData/lib/sqlite-jdbc-3.6.16.jar

DVN_INSTALLER_SCRIPT=dvninstall/install

DVN_CONFIG_TEMPLATES=dvninstall/domain.xml.TEMPLATE

DVN_DEPLOYMENT_FRAMEWORK=dvninstall/appdeploy/ant-deploy.xml dvninstall/appdeploy/build-impl.xml dvninstall/appdeploy/build.xml dvninstall/appdeploy/glassfish.properties.TEMPLATE dvninstall/appdeploy/private.properties dvninstall/appdeploy/project.properties dvninstall/appdeploy/AS.properties.TEMPLATE 

DVN_POSTGRES_DRIVERS=dvninstall/pgdriver/postgresql-8.3-603.jdbc4.jar dvninstall/pgdriver/postgresql-8.4-703.jdbc4.jar dvninstall/pgdriver/postgresql-9.0-802.jdbc4.jar dvninstall/pgdriver/postgresql-9.1-902.jdbc4.jar

${DVN_WAR_FILE}:	../../src/DVN-web/dist/DVN-web.war
	@/bin/cp ../../src/DVN-web/dist/DVN-web.war dvninstall/appdeploy/dist


../../src/DVN-web/dist/DVN-web.war:
	@echo
	@echo "ERROR: can't find application .war file (DVN-web.war)!"
	@echo "Build the DVN war file, then try again."
	@echo
	@exit 1

#@zip -r dvninstall.zip dvninstall
dvninstall.zip: ${DVN_CONFIG_TEMPLATES} ${DVN_INSTALLER_SCRIPT} ${DVN_POSTGRES_DRIVERS} ${DVN_WAR_FILE} ${DVN_CONFIG_FILES} ${DVN_SQL_FILE_TEMPLATE} ${DVN_NETWORKDATA_LIBS} ${DVN_DEPLOYMENT_FRAMEWORK}
	@echo making installer...
	@zip dvninstall.zip ${DVN_CONFIG_TEMPLATES} ${DVN_INSTALLER_SCRIPT} ${DVN_POSTGRES_DRIVERS} ${DVN_WAR_FILE} ${DVN_CONFIG_FILES} ${DVN_SQL_FILE_TEMPLATE} ${DVN_NETWORKDATA_LIBS} ${DVN_DEPLOYMENT_FRAMEWORK}
	@echo 
	@echo "Done!"

${DVN_SQL_FILE_TEMPLATE}:	${DVN_SQL_FILE_SOURCE}
	@/bin/sed 's/dvnApp/%POSTGRES_USER%/g' < ${DVN_SQL_FILE_SOURCE} > ${DVN_SQL_FILE_TEMPLATE}

${DVN_CONFIG_FILES}: 	../../working_directory/error.xsl ../../working_directory/fgdc2ddi.xsl ../../working_directory/graphml.props ../../working_directory/header.xsl ../../working_directory/jhove.conf ../../working_directory/logging.properties ../../working_directory/metadata.xsl ../../working_directory/mif2ddi.xsl ../../working_directory/neodb.props ../../working_directory/oai_dc2ddi.xsl ../../working_directory/oaicat.properties
		@/bin/cp ../../working_directory/error.xsl ../../working_directory/fgdc2ddi.xsl ../../working_directory/graphml.props ../../working_directory/header.xsl ../../working_directory/jhove.conf ../../working_directory/logging.properties ../../working_directory/metadata.xsl ../../working_directory/mif2ddi.xsl ../../working_directory/neodb.props ../../working_directory/oai_dc2ddi.xsl ../../working_directory/oaicat.properties dvninstall/config

${DVN_NETWORKDATA_LIBS}: ../../lib/dvn-lib-NetworkData-EXTRA/collections-generic-4.01.jar ../../lib/dvn-lib-NetworkData-EXTRA/colt-1.2.0.jar ../../lib/dvn-lib-NetworkData-EXTRA/concurrent-1.3.4.jar ../../lib/dvn-lib-NetworkData-EXTRA/geronimo-jta_1.1_spec-1.1.1.jar ../../lib/dvn-lib-NetworkData-EXTRA/jung-algorithms-2.0.jar ../../lib/dvn-lib-NetworkData-EXTRA/jung-api-2.0.jar ../../lib/dvn-lib-NetworkData-EXTRA/jung-visualization-2.0.jar ../../lib/dvn-lib-NetworkData-EXTRA/junit-3.8.1.jar ../../lib/dvn-lib-NetworkData-EXTRA/neo4j-index-1.1.jar ../../lib/dvn-lib-NetworkData-EXTRA/neo4j-kernel-1.1.jar ../../lib/dvn-lib-NetworkData-EXTRA/neo4j-utils-1.1.jar ../../lib/dvn-lib-NetworkData-EXTRA/nestedvm-1.0.jar ../../lib/dvn-lib-NetworkData/network_utils-1.0-SNAPSHOT.jar ../../lib/dvn-lib-NetworkData/sqlite-jdbc-3.6.16.jar ../../lib/dvn-lib-NetworkData-EXTRA/lucene-core-2.9.2.jar
	@mkdir -p dvninstall/config/networkData/lib
	@/bin/cp ../../lib/dvn-lib-NetworkData-EXTRA/collections-generic-4.01.jar ../../lib/dvn-lib-NetworkData-EXTRA/colt-1.2.0.jar ../../lib/dvn-lib-NetworkData-EXTRA/concurrent-1.3.4.jar ../../lib/dvn-lib-NetworkData-EXTRA/geronimo-jta_1.1_spec-1.1.1.jar ../../lib/dvn-lib-NetworkData-EXTRA/jung-algorithms-2.0.jar ../../lib/dvn-lib-NetworkData-EXTRA/jung-api-2.0.jar ../../lib/dvn-lib-NetworkData-EXTRA/jung-visualization-2.0.jar ../../lib/dvn-lib-NetworkData-EXTRA/junit-3.8.1.jar ../../lib/dvn-lib-NetworkData-EXTRA/neo4j-index-1.1.jar ../../lib/dvn-lib-NetworkData-EXTRA/neo4j-kernel-1.1.jar ../../lib/dvn-lib-NetworkData-EXTRA/neo4j-utils-1.1.jar ../../lib/dvn-lib-NetworkData-EXTRA/nestedvm-1.0.jar ../../lib/dvn-lib-NetworkData/network_utils-1.0-SNAPSHOT.jar ../../lib/dvn-lib-NetworkData/sqlite-jdbc-3.6.16.jar ../../lib/dvn-lib-NetworkData-EXTRA/lucene-core-2.9.2.jar dvninstall/config/networkData/lib

