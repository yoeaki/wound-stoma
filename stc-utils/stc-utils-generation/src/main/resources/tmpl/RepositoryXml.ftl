<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${templates.repository.generationClassesPath}">



	<resultMap id="${table.nameFirstLowerCamel}Map" type="${templates.entity.generationClassesPath}">
		<#list table.pk as column>
		<id column="${column.nameLower}" property="${column.nameFirstLowerCamel}" />		<!-- ${column.comment} -->
		</#list>
		<#list table.plainColumns as column>
		<result column="${column.nameLower}" property="${column.nameFirstLowerCamel}" />		<!-- ${column.comment} -->
		</#list>
	</resultMap>


	<sql id="allColumns">
		<#list table.pk as column>${column.nameLower},</#list><#list table.plainColumns as column>${column.nameLower}<#if column_has_next>,<#if ((column_index+1)%10==0)>${"\n\t\t"}</#if></#if></#list>
	</sql>
	<#if (table.pk?size>1)>
	<sql id="columns">
		<#list table.plainColumns as column>${column.nameLower}<#if column_has_next>,<#if ((column_index+1)%10==0)>${"\n\t\t"}</#if></#if></#list>
	</sql>
	<#else>
	<sql id="columns">
		<#list table.columns as column>${column.nameLower}<#if column_has_next>,<#if ((column_index+1)%10==0)>${"\n\t\t"}</#if></#if></#list>
	</sql>
	</#if>
	<sql id="table">
		<#if table.prefix?length gt 1>${table.prefix}_</#if><#if (table.modelName)??||table.modelName?length==0>${table.modelName}_</#if>${table.nameLower}
	</sql>
	<sql id="condition">
		<trim prefix="WHERE" prefixOverrides="AND |OR ">
			<#list table.columns as column>
			<if test="${column.nameFirstLowerCamel} != null">
				AND ${column.nameLower} = ${r"#"}{${column.nameFirstLowerCamel}}
			</if>
			</#list>
		</trim>
	</sql>
	<sql id="conditionPK">
		<trim prefix="WHERE" prefixOverrides="AND |OR ">
			<#list table.pk as column>
				AND ${column.nameLower} = ${r"#"}{${column.nameFirstLowerCamel}}
			</#list>
		</trim>
	</sql>
	<sql id="moreConditionPK">
		<#if (table.pk?size==1)>
		<#list table.pk as column>
		WHERE ${column.nameLower} in
		<trim prefix="(" suffix=")">
			<foreach collection="ids" item="item" separator=",">
				${r"#"}{item}
			</foreach>
		</trim>
		</#list>
		<#else>
		<trim prefix="WHERE" prefixOverrides="AND |OR ">
		<foreach collection="ids" item="item" separator=",">
		<trim prefix="(" suffix=")" prefixOverrides="AND |OR ">
			<#list table.pk as column>
				AND ${column.nameLower} = ${r"#"}{item.${column.nameFirstLowerCamel}}
			</#list>
		</trim>
		</foreach>
		</trim>
		</#if>
	</sql>

	<#if table.prefix?length gt 1>
	<insert id="save" parameterType="${templates.entity.generationClassesPath}" useGeneratedKeys="true" <#if (table.pk?size==1)><#list table.pk as column> keyProperty="${column.nameFirstLowerCamel}" </#list></#if>>
		insert into
		<include refid="table" />
		(
		<include refid="columns" />
		)
		values
		(<#list table.plainColumns as column>${r"#"}{${column.nameFirstLowerCamel},jdbcType=${column.jdbcType}}<#if column_has_next>,<#if ((column_index+1)%4==0)>${"\n\t\t"}</#if></#if></#list>
		)
	</insert>
	<insert id="saveList" parameterType="java.util.List" useGeneratedKeys="true" <#if (table.pk?size==1)><#list table.pk as column> keyProperty="${column.nameFirstLowerCamel}" </#list></#if>>
		insert into
		<include refid="table" />
		(
		<include refid="columns" />
		)
		values
		<foreach collection="list" item="item" index="index" separator=",">
		(<#list table.plainColumns as column>${r"#"}{item.${column.nameFirstLowerCamel},jdbcType=${column.jdbcType}}<#if column_has_next>,<#if ((column_index+1)%4==0)>${"\n\t\t"}</#if></#if></#list>
		)
		</foreach>
	</insert>
	<#else>
	<insert id="save" parameterType="${templates.entity.generationClassesPath}" >
		insert into
		<include refid="table" />
		(
		<include refid="columns" />
		)
		values
		(<#list table.columns as column>${r"#"}{${column.nameFirstLowerCamel},jdbcType=${column.jdbcType}}<#if column_has_next>,<#if ((column_index+1)%4==0)>${"\n\t\t"}</#if></#if></#list>
		)
	</insert>
	<insert id="saveList" parameterType="java.util.List" useGeneratedKeys="true">
		insert into
		<include refid="table" />
		(
		<include refid="columns" />
		)
		values
		<foreach collection="list" item="item" index="index" separator=",">
			(<#list table.columns as column>${r"#"}{item.${column.nameFirstLowerCamel},jdbcType=${column.jdbcType}}<#if column_has_next>,<#if ((column_index+1)%4==0)>${"\n\t\t"}</#if></#if></#list>
			)
		</foreach>
	</insert>
	</#if>

	<update id="update" parameterType="${templates.entity.generationClassesPath}">
		update
		<include refid="table" />
		<set>
			<#list table.plainColumns as column>
			<if test="${column.nameFirstLowerCamel} != null">
				${column.nameLower} = ${r"#"}{${column.nameFirstLowerCamel}},
			</if>
			</#list>
		</set>
		<include refid="conditionPK" />
	</update>

	<update id="updateAll" parameterType="${templates.entity.generationClassesPath}">
		update
		<include refid="table" />
		<set>
			<#list table.plainColumns as column>
			${column.nameLower} = ${r"#"}{${column.nameFirstLowerCamel},jdbcType=${column.jdbcType}}<#if column_has_next>,</#if>
			</#list>
		</set>
		<include refid="conditionPK" />
	</update>

	<update id="updateList" parameterType="java.util.List">
		<foreach collection="list" item="item" index="index" open="" close="" separator=";">
         update
         	<include refid="table" />
			<set>
			<#list table.plainColumns as column>
				<if test="item.${column.nameFirstLowerCamel} != null">
					${column.nameLower} = ${r"#"}{item.${column.nameFirstLowerCamel}}<#if column_has_next>,</#if>
				</if>
			</#list>
			</set>
			<trim prefix="WHERE" prefixOverrides="AND |OR ">
			<#list table.pk as column>
				AND ${column.nameLower} = ${r"#"}{item.${column.nameFirstLowerCamel}}
			</#list>
			</trim>
         </foreach>
	</update>

    <update id="updateAllList" parameterType="java.util.List">
        <foreach collection="list" item="item" index="index" open="" close="" separator=";">
            update
            <include refid="table" />
			<set>
				<#list table.plainColumns as column>
					${column.nameLower} = ${r"#"}{item.${column.nameFirstLowerCamel},jdbcType=${column.jdbcType}}<#if column_has_next>,</#if>
				</#list>
			</set>
            <trim prefix="WHERE" prefixOverrides="AND |OR ">
			<#list table.pk as column>
                AND ${column.nameLower} = ${r"#"}{item.${column.nameFirstLowerCamel}}
			</#list>
            </trim>
        </foreach>
    </update>

    <update id="modify">
        update
        <include refid="table" />
        <set>
		<#list table.plainColumns as column>
            <if test="myNew.${column.nameFirstLowerCamel} != null">
			${column.nameLower} = ${r"#"}{myNew.${column.nameFirstLowerCamel}},
            </if>
		</#list>
        </set>
		<where>
        <#list table.plainColumns as column>
            <if test="old.${column.nameFirstLowerCamel} != null">
            	and ${column.nameLower} = ${r"#"}{old.${column.nameFirstLowerCamel}}
            </if>
        </#list>
		</where>
    </update>

	<delete id="remove" parameterType="${templates.entity.generationClassesPath}">
		delete from
		<include refid="table" />
		<include refid="condition" />
	</delete>
	<delete id="removeAll">
		delete from
		<include refid="table" />
	</delete>


	<#if (table.pk?size==1)>
	<delete id="deleteById" parameterType="${table.pk[0].javaType}">
		delete from
		<include refid="table" />
		<include refid="conditionPK" />
	</delete>
	</#if>

	<delete id="deleteByIds" parameterType="list">
		delete from
		<include refid="table" />
		<include refid="moreConditionPK" />
	</delete>
	<select id="getById" resultMap="${table.nameFirstLowerCamel}Map" parameterType="<#if (table.pk?size==1)>${table.pk[0].javaType}<#else>${templates.entity.generationClassesPath}</#if>">
		select
		<include refid="allColumns" />
		from
		<include refid="table" />
		<include refid="conditionPK" />
	</select>
	<#--<select id="load" resultMap="${table.nameFirstLowerCamel}Map" parameterType="${templates.entity.generationClassesPath}">-->
		<#--select-->
		<#--<include refid="allColumns" />-->
		<#--from-->
		<#--<include refid="table" />-->
		<#--<include refid="conditionPK" />-->
	<#--</select>-->
	<select id="getOne" resultMap="${table.nameFirstLowerCamel}Map"
		parameterType="${templates.entity.generationClassesPath}">
		select
		<include refid="allColumns" />
		from
		<include refid="table" />
		<include refid="condition" />
	</select>
	<select id="count" resultType="java.lang.Integer"
		parameterType="${templates.entity.generationClassesPath}">
		select
		count(1)
		from
		<include refid="table" />
		<include refid="condition" />
	</select>

    <#--<select id="countMap" resultType="java.lang.Integer"-->
            <#--parameterType="${templates.entity.generationClassesPath}" databaseId="sqlserver">-->
        <#--select ISNULL((select-->
        <#--count(1)-->
        <#--from-->
        <#--<include refid="table" />-->
        <#--<trim prefix="WHERE" prefixOverrides="AND |OR ">-->
            <#--<if test="entity != null">-->
                <#--<#list columns as column>-->
                    <#--<if test="entity.${column.nameFirstLower} != null">-->
                        <#--AND ${column.nameLower} = ${r"#"}{entity.${column.nameFirstLower}}-->
                    <#--</if>-->
                <#--</#list>-->
            <#--</if>-->
            <#--<foreach collection="map.keys" item="key">-->
                <#--<if test="map[key] != null and !map[key].equals('')">-->
                    <#--AND ${r"$"}{key} IN-->
                    <#--<foreach collection="map[key]" item="val" open="(" close=")" separator=",">-->
                        <#--${r"#"}{val}-->
                    <#--</foreach>-->
                <#--</if>-->
            <#--</foreach>-->
        <#--</trim>-->
        <#--), 0)-->
    <#--</select>-->

	<select id="countAll" resultType="java.lang.Integer">
		select
		count(1)
		from
		<include refid="table" />
	</select>

	<select id="existsById"  resultType="java.lang.Boolean" parameterType="<#if (table.pk?size==1)>${table.pk[0].javaType}<#else>${templates.entity.generationClassesPath}</#if>">
		select
		1
		from
		<include refid="table" />
		<include refid="conditionPK" />
	</select>

	<select id="findAll" resultMap="${table.nameFirstLowerCamel}Map">
		select
		<include refid="allColumns" />
		from
		<include refid="table" />
	</select>
	<select id="find" resultMap="${table.nameFirstLowerCamel}Map" parameterType="${templates.entity.generationClassesPath}">
		select
		<include refid="allColumns" />
		from
		<include refid="table" />
		<include refid="condition" />
	</select>

	<select id="findByMap" parameterType="java.util.Map" resultMap="${table.nameFirstLowerCamel}Map">
		select
		<include refid="allColumns" />
		from
		<include refid="table" />
		<trim prefix="WHERE" prefixOverrides="AND |OR ">
			<foreach collection="map.keys" item="key">
				<if test="map[key] != null and !map[key].equals('')">
					AND ${r"$"}{key} = ${r"#"}{map[${r"$"}{key}]}
				</if>
			</foreach>
		</trim>
	</select>

	<select id="findByIds" parameterType="java.util.List"
		resultMap="${table.nameFirstLowerCamel}Map">
		select
		<include refid="allColumns" />
		from
		<include refid="table" />
		<include refid="moreConditionPK" />
	</select>

	<select id="findByCriteria" parameterType="java.util.Map" resultMap="${table.nameFirstLowerCamel}Map">
		select
		<include refid="allColumns" />
		from
		<include refid="table" />
		<trim prefix="WHERE" prefixOverrides="AND |OR ">
			<foreach collection="list" item="item" index="index">
				<choose>
					<when test="item.op == 'in'">
						AND ${r"$"}{item.field} ${r"$"}{item.op}
						<foreach item="obj" collection="item.value" index="idx" open="(" separator="," close=")">
							${r"#"}{list[${r"$"}{index}].value[${r"$"}{idx}]}
			        	</foreach>
					</when>
					<when test="item.op == 'not in'">
						AND ${r"$"}{item.field} ${r"$"}{item.op}
						<foreach item="obj" collection="item.value" index="idx" open="(" separator="," close=")">
							${r"#"}{list[${r"$"}{index}].value[${r"$"}{idx}]}
			        	</foreach>
					</when>
					<otherwise>
						AND ${r"$"}{item.field} ${r"$"}{item.op} ${r"#"}{list[${r"$"}{index}].value}
					</otherwise>
				</choose>
			</foreach>
		</trim>
	</select>
	<select id="page" resultMap="${table.nameFirstLowerCamel}Map" parameterType="${templates.entity.generationClassesPath}">
		select
		<include refid="allColumns" />
		from
		<include refid="table" />
		<include refid="condition" />
	</select>

	<select id="pageByMap" parameterType="java.util.Map" resultMap="${table.nameFirstLowerCamel}Map">
		select
		<include refid="allColumns" />
		from
		<include refid="table" />
		<trim prefix="WHERE" prefixOverrides="AND |OR ">
			<foreach collection="map.keys" item="key">
				<if test="map[key] != null and !map[key].equals('')">
					AND ${r"$"}{key} = ${r"#"}{map[${r"$"}{key}]}
				</if>
			</foreach>
		</trim>
	</select>

	<select id="pageByCriteria" parameterType="java.util.Map" resultMap="${table.nameFirstLowerCamel}Map">
		select
		<include refid="allColumns" />
		from
		<include refid="table" />
		<trim prefix="WHERE" prefixOverrides="AND |OR ">
			<foreach collection="list" item="item" index="index">
				<choose>
					<when test="item.op == 'in'">
						AND ${r"$"}{item.field} ${r"$"}{item.op}
						<foreach item="obj" collection="item.value" index="idx" open="(" separator="," close=")">
							${r"#"}{list[${r"$"}{index}].value[${r"$"}{idx}]}
			        	</foreach>
					</when>
					<when test="item.op == 'not in'">
						AND ${r"$"}{item.field} ${r"$"}{item.op}
						<foreach item="obj" collection="item.value" index="idx" open="(" separator="," close=")">
							${r"#"}{list[${r"$"}{index}].value[${r"$"}{idx}]}
			        	</foreach>
					</when>
					<otherwise>
						AND ${r"$"}{item.field} ${r"$"}{item.op} ${r"#"}{list[${r"$"}{index}].value}
					</otherwise>
				</choose>
			</foreach>
		</trim>
	</select>




</mapper>
