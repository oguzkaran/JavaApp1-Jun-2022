package com.karandev.util.mapstruct;

import com.karandev.util.mapstruct.annotation.ToOptional;
import com.karandev.util.mapstruct.annotation.ToType;
import org.mapstruct.Named;

import java.util.Optional;

public interface IOptionalMapper {
    @Named("toOptional")
    @ToOptional
    static <T> Optional<T> toOptional(T t)
    {
        return Optional.ofNullable(t);
    }

    @Named("toType")
    @ToType
    static <T> T toType(Optional<T> opt)
    {
        return opt.orElse(null);
    }
}
