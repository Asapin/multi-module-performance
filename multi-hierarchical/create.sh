#!/bin/bash

data=(a b c d e f g h i j k l m n o p q r s t u v w x y z)

mkdir -p multi-hierarchical-web-ui/src/main/java/com/sebastian_daschner/maven_test/

for val in ${data[@]}; do
    upperVal=${val^^}

    mkdir -p multi-hierarchical-$val/multi-hierarchical-$val-{api,core,model,ui}/src/main/java/com/sebastian_daschner/maven_test/$val/

    tee multi-hierarchical-$val/multi-hierarchical-$val-api/src/main/java/com/sebastian_daschner/maven_test/$val/${upperVal}Bean.java << EOF
package com.sebastian_daschner.maven_test.$val;

import jakarta.ejb.Local;

@Local
public interface ${upperVal}Bean {

    String get();

    ${upperVal} get(String id);

}

EOF

    tee multi-hierarchical-$val/multi-hierarchical-$val-core/src/main/java/com/sebastian_daschner/maven_test/$val/${upperVal}BeanImpl.java << EOF
package com.sebastian_daschner.maven_test.$val;

import jakarta.ejb.Stateless;

@Stateless
public class ${upperVal}BeanImpl implements ${upperVal}Bean {

    @Override
    public String get() {
        return "${val}";
    }

    @Override
    public ${upperVal} get(String id) {
        return new ${upperVal}(id);
    }

}
EOF
    
    tee multi-hierarchical-$val/multi-hierarchical-$val-model/src/main/java/com/sebastian_daschner/maven_test/$val/${upperVal}.java << EOF
package com.sebastian_daschner.maven_test.$val;

public class ${upperVal} {

    private String $val;

    public $upperVal(String $val) {
        this.$val = $val;
    }

    public String get${upperVal}() {
        return $val;
    }

    public void set${upperVal}(String $val) {
        this.$val = $val;
    }

}
EOF

    tee multi-hierarchical-$val/multi-hierarchical-$val-ui/src/main/java/com/sebastian_daschner/maven_test/$val/${upperVal}Resource.java << EOF
package com.sebastian_daschner.maven_test.$val;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("${val}")
public class ${upperVal}Resource {

    @Inject
    ${upperVal}Bean ${val};

    @GET
    public String get() {
        return ${val}.get();
    }

    @GET
    @Path("{id}")
    public ${upperVal} get(@PathParam("id") String id) {
        return ${val}.get(id);
    }

}
EOF

    tee multi-hierarchical-$val/pom.xml << EOF
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <artifactId>multi-hierarchical-${val}</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>

    <parent>
        <groupId>com.sebastian-daschner</groupId>
        <artifactId>multi-hierarchical-parent</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <modules>
        <module>multi-hierarchical-${val}-api</module>
        <module>multi-hierarchical-${val}-core</module>
        <module>multi-hierarchical-${val}-model</module>
        <module>multi-hierarchical-${val}-ui</module>
    </modules>

</project>
EOF

    tee multi-hierarchical-$val/multi-hierarchical-$val-core/pom.xml << EOF
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <artifactId>multi-hierarchical-${val}-core</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <parent>
        <groupId>com.sebastian-daschner</groupId>
        <artifactId>multi-hierarchical-${val}</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>com.sebastian-daschner</groupId>
            <artifactId>multi-hierarchical-${val}-api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>com.sebastian-daschner</groupId>
            <artifactId>multi-hierarchical-${val}-model</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>jakarta.platform</groupId>
            <artifactId>jakarta.jakartaee-api</artifactId>
            <version>11.0.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

</project>
EOF

    tee multi-hierarchical-$val/multi-hierarchical-$val-api/pom.xml << EOF
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <artifactId>multi-hierarchical-${val}-api</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <parent>
        <groupId>com.sebastian-daschner</groupId>
        <artifactId>multi-hierarchical-${val}</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>com.sebastian-daschner</groupId>
            <artifactId>multi-hierarchical-${val}-model</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>jakarta.platform</groupId>
            <artifactId>jakarta.jakartaee-api</artifactId>
            <version>11.0.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

</project>
EOF

    tee multi-hierarchical-$val/multi-hierarchical-$val-model/pom.xml << EOF
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <artifactId>multi-hierarchical-${val}-model</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <parent>
        <groupId>com.sebastian-daschner</groupId>
        <artifactId>multi-hierarchical-${val}</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

</project>
EOF

    tee multi-hierarchical-$val/multi-hierarchical-$val-ui/pom.xml << EOF
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <artifactId>multi-hierarchical-${val}-ui</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <parent>
        <groupId>com.sebastian-daschner</groupId>
        <artifactId>multi-hierarchical-${val}</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>com.sebastian-daschner</groupId>
            <artifactId>multi-hierarchical-${val}-api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>com.sebastian-daschner</groupId>
            <artifactId>multi-hierarchical-${val}-core</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>com.sebastian-daschner</groupId>
            <artifactId>multi-hierarchical-${val}-model</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>jakarta.platform</groupId>
            <artifactId>jakarta.jakartaee-api</artifactId>
            <version>11.0.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

</project>
EOF

done

tee multi-hierarchical-web-ui/pom.xml << EOF
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <artifactId>multi-hierarchical-web-ui</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <parent>
        <groupId>com.sebastian-daschner</groupId>
        <artifactId>multi-hierarchical-parent</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <dependencies>
EOF

tee pom.xml << EOF
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.sebastian-daschner</groupId>
    <artifactId>multi-hierarchical-parent</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>

    <modules>
        <module>multi-hierarchical-web-ui</module>
EOF

for val in ${data[@]}; do

tee -a multi-hierarchical-web-ui/pom.xml << EOF
        <dependency>
            <groupId>com.sebastian-daschner</groupId>
            <artifactId>multi-hierarchical-${val}-api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>com.sebastian-daschner</groupId>
            <artifactId>multi-hierarchical-${val}-core</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>com.sebastian-daschner</groupId>
            <artifactId>multi-hierarchical-${val}-model</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>com.sebastian-daschner</groupId>
            <artifactId>multi-hierarchical-${val}-ui</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
EOF

tee -a pom.xml << EOF
        <module>multi-hierarchical-${val}</module>
EOF

done
tee -a multi-hierarchical-web-ui/pom.xml << EOF
        <dependency>
            <groupId>jakarta.platform</groupId>
            <artifactId>jakarta.jakartaee-api</artifactId>
            <version>11.0.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <properties>
        <failOnMissingWebXml>false</failOnMissingWebXml>
    </properties>

</project>
EOF

tee -a pom.xml << EOF
    </modules>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <failOnMissingWebXml>false</failOnMissingWebXml>
    </properties>
</project>
EOF

tee -a multi-hierarchical-web-ui/src/main/java/com/sebastian_daschner/maven_test/JAXRSConfiguration.java << EOF
package com.sebastian_daschner.maven_test;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {
    // nothing to configure
}
EOF
