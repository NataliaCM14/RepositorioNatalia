<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="pokedex">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <div class="grid-container">
        <xsl:apply-templates select="pokemon">
        <xsl:sort select="nombre" order=""></xsl:sort>
        </xsl:apply-templates>
    </div>
    </body>
</html>
</xsl:template>

<xsl:template match="pokemon">
    <xsl:variable name="tipo">
        <xsl:value-of select="tipos"/>
    </xsl:variable>

    <xsl:variable name="colorFondo">
        <xsl:choose>
            <xsl:when test="contains($tipo, 'Planta')">green</xsl:when>
            <xsl:when test="contains($tipo, 'Fuego')">red</xsl:when>
            <xsl:when test="contains($tipo, 'Agua')">blue</xsl:when>
            <xsl:when test="contains($tipo, 'Veneno')">yellow</xsl:when>
            <xsl:when test="contains($tipo, 'Bicho')">purple</xsl:when>
            <xsl:otherwise>white</xsl:otherwise>
        </xsl:choose>
    </xsl:variable>

    <div class="item">
        <img alt="">

            <xsl:attribute name="src">
                
            <xsl:value-of select="imagen" />
                
            </xsl:attribute>
                
        </img>
        
        
        <p><xsl:value-of select="nombre"/></p>

    </div>
</xsl:template>
</xsl:stylesheet>