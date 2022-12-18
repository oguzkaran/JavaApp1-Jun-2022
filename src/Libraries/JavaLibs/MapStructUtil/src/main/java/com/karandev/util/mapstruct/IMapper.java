package com.karandev.util.mapstruct;

public interface IMapper<Src, Dest> {
    Dest toDestination(Src src);
    Src toSource(Dest dest);
}
