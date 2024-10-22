<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <!-- Головний шаблон -->
    <xsl:template match="/">
        <GroupedGuns>
            <!-- Отримуємо унікальні значення Origin -->
            <xsl:for-each select="//Gun[not(Origin=preceding-sibling::Gun/Origin)]">
                <Group>
                    <Origin>
                        <xsl:value-of select="Origin"/>
                    </Origin>
                    <GunsByOrigin>
                        <!-- Групуємо пістолети за значенням Origin -->
                        <xsl:for-each select="//Gun[Origin=current()/Origin]">
                            <Gun>
                                <Model><xsl:value-of select="Model"/></Model>
                                <Handy><xsl:value-of select="Handy"/></Handy>
                                <Material><xsl:value-of select="Material"/></Material>
                                <TTC>
                                    <Range><xsl:value-of select="TTC/Range"/></Range>
                                    <SightingRange><xsl:value-of select="TTC/SightingRange"/></SightingRange>
                                    <Magazine><xsl:value-of select="TTC/Magazine"/></Magazine>
                                    <Optics><xsl:value-of select="TTC/Optics"/></Optics>
                                </TTC>
                            </Gun>
                        </xsl:for-each>
                    </GunsByOrigin>
                </Group>
            </xsl:for-each>
        </GroupedGuns>
    </xsl:template>
</xsl:stylesheet>
