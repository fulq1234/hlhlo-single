package com.lummei.jobapp.protocol;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;

public class DataDictionary implements Serializable {
    private static final long serialVersionUID = 8136195881239986613L;
    private @Getter
    @Setter
    Long id;
    private @Getter @Setter String dataType;
    private @Getter @Setter String description;
    private @Getter @Setter String codeName;
    private @Getter @Setter String codeValue;
    private @Getter @Setter String parentValue;
    private @Getter @Setter int displayOrder;
    private @Getter @Setter String typeName;
    private @Getter @Setter
    Date createTime;
    private @Getter @Setter Date updateTime;
    private @Getter @Setter
    Set<DataDictionary> children;

    transient private static Map<String, List<DataDictionary>> dataDictionaryMap = Collections
            .synchronizedMap(new HashMap<String, List<DataDictionary>>());

    public DataDictionary() {
    }

    public DataDictionary(String codeName, String codeValue, String description, int displayOrder) {
        this.codeName = codeName;
        this.codeValue = codeValue;
        this.typeName = this.getClass().getName();
        this.description = description;
        this.displayOrder = displayOrder;
        this.parentValue = null;

        registDataDictionary(this);
    }

    public DataDictionary(String codeName, String codeValue, String description, int displayOrder, String parentValue) {
        this.codeName = codeName;
        this.codeValue = codeValue;
        this.typeName = this.getClass().getName();
        this.description = description;
        this.displayOrder = displayOrder;
        this.parentValue = parentValue;

        DataDictionary dictionary = getDataDictionaryByValue(parentValue, this.getClass());
        if (dictionary != null) {
            if (dictionary.getChildren() == null) {
                dictionary.setChildren(new HashSet<>());
            }
            dictionary.getChildren().add(this);
        }

        registDataDictionary(this);
    }

    public static void registDataDictionary(DataDictionary dataDictionary) {
        if (!dataDictionaryMap.containsKey(dataDictionary.getTypeName())) {
            dataDictionaryMap.put(dataDictionary.getTypeName(), new ArrayList<DataDictionary>());
        }
        List<DataDictionary> dataDictionaries = dataDictionaryMap.get(dataDictionary.getTypeName());
        dataDictionaries.add(dataDictionary);
    }

    public static DataDictionary getDataDictionaryByValue(String value, Class<?> clazz) {
        List<DataDictionary> dataDictionaries = dataDictionaryMap.get(clazz.getName());
        for (DataDictionary dataDictionary : dataDictionaries) {
            if (StringUtils.equalsIgnoreCase(value, dataDictionary.getCodeValue())) {
                return dataDictionary;
            }
        }
        return null;
    }

    public static DataDictionary getDataDictionaryByKey(String codeName, Class<? extends DataDictionary> clazz) {
        List<DataDictionary> dataDictionaries = dataDictionaryMap.get(clazz.getName());
        if(dataDictionaries == null){
            return null;
        }
        for (DataDictionary dataDictionary : dataDictionaries) {
            if (StringUtils.equals(codeName, dataDictionary.getCodeName())) {
                return dataDictionary;
            }
        }
        return null;
    }

    /**
     * 根据ID获取字典数据
     *
     * @param id
     *
     * @return
     */
    public static DataDictionary getDataDictionaryById(Long id) {
        List<DataDictionary> ds = new ArrayList<DataDictionary>();

        for (List<DataDictionary> list : dataDictionaryMap.values()) {
            ds.addAll(list);
        }

        for (DataDictionary dataDictionary : ds) {
            if (id.longValue() == dataDictionary.getId()) {
                return dataDictionary;
            }
        }

        return null;
    }

    /**
     * 根据Description查询对应的字典数据
     *
     * @param desc
     * @param clazz
     * @return
     */
    public static DataDictionary getDataDictionaryByDescription(String desc, Class<? extends DataDictionary> clazz) {

        if (StringUtils.isBlank(desc)) {
            return null;
        }

        List<DataDictionary> dataDictionaries = dataDictionaryMap.get(clazz.getName());

        for (DataDictionary dataDictionary : dataDictionaries) {
            if (StringUtils.equalsIgnoreCase(desc, dataDictionary.getDescription())) {
                return dataDictionary;
            }
        }

        return null;
    }

    public static Map<String, List<DataDictionary>> getDataDictionaryMap() {
        return dataDictionaryMap;
    }

    public static List<DataDictionary> getEnumItemsByClassName(String className) {
        return dataDictionaryMap.get(className);
    }

    public static List<DataDictionary> getEnumItemsByClass(Class<? extends DataDictionary> clazz) {
        List<DataDictionary> list = dataDictionaryMap.get(clazz.getName());
        List<DataDictionary> result = null;
        if (list != null && !list.isEmpty()) {
            result = new ArrayList<>();
            for (DataDictionary dd: list) {
                if (StringUtils.isBlank(dd.getParentValue())) {
                    result.add(dd);
                }
            }
        }
        return result;
    }

    public static List<DataDictionary> getEnumItemsByClassAndKeyLike(Class<? extends DataDictionary> clazz, String keywords) {
        List<DataDictionary> list = dataDictionaryMap.get(clazz.getName());
        List<DataDictionary> result = null;
        if (list != null && !list.isEmpty()) {
            result = new ArrayList<>();
            for (DataDictionary dd: list) {
                if (dd.getChildren() == null && dd.getCodeName().contains(keywords)) {
                    result.add(dd);
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        } else {
            if (obj == null) {
                return false;
            }
            return this.getClass() == obj.getClass() && this.getCodeName().equals(((DataDictionary) obj).getCodeName())
                    && this.codeValue.equals(((DataDictionary) obj).getCodeValue());
        }
    }
}
