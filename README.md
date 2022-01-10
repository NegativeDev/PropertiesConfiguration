# PropertiesConfiguration
Configuration file for .properties similar to how Bukkit does it YAML configuration

# Adding to Project
Repository
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
Dependency
```xml
<dependency>
    <groupId>com.github.NegativeKB</groupId>
	<artifactId>PropertiesConfiguration</artifactId>
	<version>{VERSION}</version>
    <scope>compile</scope>
</dependency>
```
Build Configuration
```xml
<configuration>
  <relocations>
    <relocation>
      <pattern>dev.negativekb.configuration</pattern>
      <shadedPattern>{YOUR PACKAGE NAME}</shadedPattern>
    </relocation>
  </relocations>
</configuration>
```

# Examples
```java
PropertiesFile propertiesFile = new PropertiesFile(this.getDataFolder().getPath(), "database.properties");
// Using PropertiesFile#createFile(true) will create the file
// with the pre-defined values you put in the resource area        
propertiesFile.createFile(true);

PropertiesConfiguration config = new PropertiesConfiguration(propertiesFile.asFile());
// Now that you have declared a new Configuration instance you can now get
// and add values!

config.setString("my.custom.setting", "Hello, World!");
config.save();

String customSetting = config.getString("my.cuystom.setting");
```
